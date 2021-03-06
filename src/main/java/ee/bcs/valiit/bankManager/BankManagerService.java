package ee.bcs.valiit.bankManager;

import ee.bcs.valiit.solution.exception.SampleApplicationException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BankManagerService {
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void looKonto(BankManagerClass request) {
        bankAccountRepository.looKonto(request);
    }
    public void registerUser(LoginRequestClass request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);
        bankAccountRepository.registerUser(request);
    }

    public String password2(LoginRequestClass body) {
        String passwordServ = bankAccountRepository.getPasswordRep(body.getUsername());
//        if (body.getPassword().equals(passwordServ)) {
          if (passwordEncoder.matches(body.getPassword(), passwordServ)) {
            Date today = new Date();
            Date tokenExpirationDate = new Date(today.getTime() + 1000 * 60 * 60 * 24);
            JwtBuilder jwtBuilder = Jwts.builder()
                    .setExpiration(tokenExpirationDate)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
                    .claim("username", body.getPassword());
            return jwtBuilder.compact();
        } else {
            return "Proovi uuesti";
        }

    }


    public String saldo(String accountNr) {
        Customers account = customersRepository.getOne(accountNr);
        return  "Konto saldo on " + account.getBalance() + " EUR.";
    }

    public void laeRaha(String accountNr, BankManagerClass request) {
        if (request.getBalance() < 0) {
            throw new SampleApplicationException("Summa peab olema positiivne.");
        }
        Customers account = customersRepository.getOne(accountNr);
        Double balance = account.getBalance() + request.getBalance();
        account.setBalance(balance);
        customersRepository.save(account);
    }

    public void mahaRaha(String accountNr, BankManagerClass request) {
        if (request.getBalance() < 0) {
            throw new SampleApplicationException("Summa peab olema positiivne.");
        }
        Customers account = customersRepository.getOne(accountNr);
        Double balance = account.getBalance() - request.getBalance();
        account.setBalance(balance);
        customersRepository.save(account);
    }

    public void transfer(String accountNr, String accountNr2, BankManagerClass request) {
        if (request.getBalance() < 0) {
            throw new SampleApplicationException("Summa peab olema positiivne.");
        }
        Customers account = customersRepository.getOne(accountNr);
        Customers account2 = customersRepository.getOne(accountNr2);
        Double balance = account.getBalance() - request.getBalance();
        Double balance2 = account2.getBalance() + request.getBalance();
        account.setBalance(balance);
        account2.setBalance(balance2);
        customersRepository.save(account);
        customersRepository.save(account2);
    }
}
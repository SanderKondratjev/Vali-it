package ee.bcs.valiit.bankManager;

import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankManagerService {
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void looKonto(BankManagerClass request) {
        bankAccountRepository.looKonto(request);
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
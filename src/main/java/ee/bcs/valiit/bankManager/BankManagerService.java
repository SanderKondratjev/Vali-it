package ee.bcs.valiit.bankManager;

import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankManagerService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void looKonto(BankManagerClass request) {
        bankAccountRepository.looKonto(request);
    }

    public String saldo(String accountNr) {
        Double balance = bankAccountRepository.saaSaldo(accountNr);
        return "Konto saldo on " + balance + " EUR.";
    }

    public void laeRaha(String accountNr, BankManagerClass request) {
        if (request.getBalance() < 0) {
            throw new SampleApplicationException("Summa peab olema positiivne.");
        }
        Double balance = bankAccountRepository.saaSaldo(accountNr);
        balance += request.getBalance();
        bankAccountRepository.uuendaSaldo(accountNr, balance);
    }

    public void mahaRaha(String accountNr, BankManagerClass request) {
        if (request.getBalance() < 0) {
            throw new SampleApplicationException("Summa peab olema positiivne.");
        }
        Double balance = bankAccountRepository.saaSaldo(accountNr);
        balance -= request.getBalance();
        bankAccountRepository.uuendaSaldo(accountNr, balance);

    }

    public void transfer(String accountNr, String accountNr2, BankManagerClass request) {
        if (request.getBalance() < 0) {
            throw new SampleApplicationException("Summa peab olema positiivne.");
        }
        Double balance = bankAccountRepository.saaSaldo(accountNr2);
        balance += request.getBalance();
        Double balance2 = bankAccountRepository.saaSaldo(accountNr);
        balance2 -= request.getBalance();
        bankAccountRepository.uuendaSaldo(accountNr, balance2);
        bankAccountRepository.uuendaSaldo(accountNr2, balance);
    }
}
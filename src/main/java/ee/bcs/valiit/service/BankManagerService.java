package ee.bcs.valiit.service;

import ee.bcs.valiit.controller.BankManagerClass;
import ee.bcs.valiit.repository.BankAccountRepository;
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
        Double balance = bankAccountRepository.saldo(accountNr);
        return "Konto saldo on " + balance + " EUR.";
    }
}

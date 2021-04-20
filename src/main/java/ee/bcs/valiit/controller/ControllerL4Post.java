package ee.bcs.valiit.controller;

import ee.bcs.valiit.bankManager.BankManagerClass;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ControllerL4Post {
    public HashMap<String, Double> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {

    }

    @GetMapping("lesson40")
    public String info() {

        return "Sisesta mida soovid teha: 1. Loo konto " +
                "2. Konto saldo " +
                "3. Lae raha " +
                "4. Võta raha " +
                "5. Tee ülekanne " +
                "6. Välju.";
    }

    @PostMapping("lesson40/1") // 1. Loo konto
    public void looKonto(@RequestBody BankManagerClass request) {
        accountBalanceMap.put(request.getAccountNr(), request.getBalance());
    }

    @GetMapping("lesson40/2/{accountNr}") //2. Konto saldo
    public String saldo(@PathVariable("accountNr") String accountNr) {
        double balance = accountBalanceMap.get(accountNr);
        return "Konto saldo on " + balance;
    }

    @PutMapping("lesson40/3/{accountNr}") //3. Lae raha
    public void laeRaha(@PathVariable("accountNr") String accountNr,
                        @RequestBody BankManagerClass request) {
        Double balance = accountBalanceMap.get(accountNr) + request.getBalance();
        accountBalanceMap.put(accountNr, balance);
    }

    @PutMapping("lesson40/4/{accountNr}") //4. Maha raha
    public void mahaRaha(@PathVariable("accountNr") String accountNr,
                         @RequestBody BankManagerClass request) {
        Double balance = accountBalanceMap.get(accountNr) - request.getBalance();
        accountBalanceMap.put(accountNr, balance);
    }

    @PutMapping("lesson40/5/{accountNr}/{accountNr2}")
    public void transfer(@PathVariable("accountNr") String accountNr,
                         @PathVariable("accountNr2") String accountNr2,
                         @RequestBody BankManagerClass request) {
        Double balance = accountBalanceMap.get(accountNr) - request.getBalance();
        Double balance2 = accountBalanceMap.get(accountNr2) + request.getBalance();
        accountBalanceMap.put(accountNr, balance);
        accountBalanceMap.put(accountNr2, balance2);
    }
}


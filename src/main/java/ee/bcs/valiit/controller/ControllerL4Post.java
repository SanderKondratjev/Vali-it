package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ControllerL4Post {
    public HashMap<String, Double> accountBalanceMap = new HashMap<>();

    @GetMapping("lesson4")
    public String info() {

        return "Sisesta mida soovid teha: 1. Loo konto " +
                "2. Konto saldo " +
                "3. Lae raha " +
                "4. Võta raha " +
                "5. Tee ülekanne " +
                "6. Välju.";
    }

    @GetMapping("lesson4/1/{accountNr}") // 1. Loo konto
    public String looKonto(@PathVariable("accountNr") String accountNr) {
        accountBalanceMap.put(accountNr, 0.0);
        return "Uue konto nr on " + accountNr;
    }

    @GetMapping("lesson4/2/{accountNr}") //2. Konto saldo
    public String saldo(@PathVariable("accountNr") String accountNr) {

        double balance = accountBalanceMap.get(accountNr);
        return "Konto saldo on " + balance;
    }

    @GetMapping("lesson4/3/{accountNr}/{balanceplus}") //3. Lae raha
    public String laeRaha(@PathVariable("accountNr") String accountNr,
                          @PathVariable("balanceplus") double balanceplus) {
        double deposit = 0;
        if (balanceplus > 0) {
            deposit = accountBalanceMap.get(accountNr) + balanceplus;
            accountBalanceMap.put(accountNr, deposit);
        }
        return "Su kontosaldo kontol " + accountNr + "on " + balanceplus + " EUR.";
    }

    @GetMapping("lesson4/4/{accountNr}/{withdraw}")
    public String mahaRaha(@PathVariable("accountNr") String accountNr,
                           @PathVariable("withdraw") double withdraw) {
        double remove = 0;
        if (withdraw > 0) {
            remove = accountBalanceMap.get(accountNr) - withdraw;
            accountBalanceMap.put(accountNr, remove);
        }
        return "Su kontosaldo kontol " + accountNr + " on " + remove;
    }

    @GetMapping("lesson4/5/{accountNr}/{accountNr2}/{transfer}")
    public String transfer(@PathVariable("accountNr") String accountNr,
                           @PathVariable("accountNr2") String accountNr2,
                           @PathVariable("transfer") double transfer) {
        double kanne = 0;
        double kanne2 = accountBalanceMap.get(accountNr2);
        if (transfer > 0) {
            kanne = accountBalanceMap.get(accountNr) - transfer;
            kanne2 = accountBalanceMap.get(accountNr2) + transfer;
            accountBalanceMap.put(accountNr, kanne);
        }
        return "Su kontosaldo kontol " + accountNr2 + " on " + kanne + " ja kontol " +
                accountNr + " on " + kanne2;
    }
}


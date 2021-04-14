package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ControllerL4 {
    static Map<String, Double> accountBalanceMap = new HashMap<>();
    static String acoountNr = "---";
    static Double balance = 0.0;

    @GetMapping("lesson4")
    public String accountBalanceMap() {
        return "Kirjuta KONTONR asemele konto number ja SALDO asemele " +
                "algsaldo localhost:8080/lesson4/KONTONR?balance=SALDO";
    }

    @GetMapping("lesson4/{accountNr}")
    public String accountBalanceMap(@PathVariable ("accountNr") String accountNrUrl,
                                    @RequestParam("balance") Double balanceUrl) {
//        accountNr = accountNrUrl;
//        balance = balanceUrl;
        return "Konto nr on " + accountNrUrl + " ja konto saldo on " + balanceUrl + " EUR.";
    }
}
//    public String lesson4(@PathVariable("accountNr") String accountNr) {


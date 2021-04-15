package ee.bcs.valiit.tasks;

import ee.bcs.valiit.controller.L4Class;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

public class Lesson5 {
    // TODO täienda oma BankControllerit nii, et sa hoiad Map-is konto balanssi asemel konto objekti
    //  1)
    // Selleks loo uus konto objekt, mis sisaldab minimaalselt
    // * kontoNr
    // * kontoOmanikuNimi
    // * balanss
    // * kas konto on lukustatud
    // 2)
    // täienda konto loomis teenust nii, et sa salvestad ka konto omaniku nime
    // 3)
    // loo 2 uut teenust: lockAccount ja unlockAccount
    // 4)
    // juhul kui konto on lukustatud ei tohi saada sellele kontole raha juurde kande ega kontolt raha ära võtta
    // ehk siis withdrawMoney, depositMoney ja transferMoney teenused ei tohi töötada
    public HashMap<String, Double> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {

    }

    @GetMapping("lesson5")
    public String info() {

        return "Sisesta mida soovid teha:\n " +
                "lesson5/1/UUSKONTONR Loo konto\n " +
                "lesson5/2/MISKONTONR Konto saldo\n " +
                "lesson5/3/KUHUKONTOLE Lae raha\n " +
                "lesson5/4/KUSTKONTOLT Võta raha\n " +
                "lesson5/5/KUSTKONTOLT/KUHUKONTOLE Tee ülekanne\n " +
                "lesson5/6/ Välju.\n";
    }

    @PostMapping("lesson5/1") // 1. Loo konto
    public void looKonto(@RequestBody L4Class request) {
        accountBalanceMap.put(request.getAccountNr(), request.getBalance());
    }

    @GetMapping("lesson5/2/{accountNr}") //2. Konto saldo
    public String saldo(@PathVariable("accountNr") String accountNr) {
        double balance = accountBalanceMap.get(accountNr);
        return "Konto saldo on " + balance;
    }

    @PutMapping("lesson5/3/{accountNr}") //3. Lae raha
    public void laeRaha(@PathVariable("accountNr") String accountNr,
                        @RequestBody L4Class request) {
        Double balance = accountBalanceMap.get(accountNr) + request.getBalance();
        accountBalanceMap.put(accountNr, balance);
    }

    @PutMapping("lesson5/4/{accountNr}") //4. Maha raha
    public void mahaRaha(@PathVariable("accountNr") String accountNr,
                         @RequestBody L4Class request) {
        Double balance = accountBalanceMap.get(accountNr) - request.getBalance();
        accountBalanceMap.put(accountNr, balance);
    }

    @PutMapping("lesson5/5/{accountNr}/{accountNr2}")
    public void transfer(@PathVariable("accountNr") String accountNr,
                         @PathVariable("accountNr2") String accountNr2,
                         @RequestBody L4Class request) {
        Double balance = accountBalanceMap.get(accountNr) - request.getBalance();
        Double balance2 = accountBalanceMap.get(accountNr2) + request.getBalance();
        accountBalanceMap.put(accountNr, balance);
        accountBalanceMap.put(accountNr2, balance2);
    }
}

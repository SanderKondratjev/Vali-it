package ee.bcs.valiit.tasks;

import ee.bcs.valiit.bankManager.BankManagerClass;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
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
    public HashMap<String, BankManagerClass> accountBalanceMap = new HashMap<>();

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
                "lesson5/6/MISKONTONR Lukusta\n" +
                "lesson5/7/MISKONTONR Vabasta\n";
    }

    @PostMapping("lesson5/1") // 1. Loo konto
    public void looKonto(@RequestBody BankManagerClass request) {
        accountBalanceMap.put(request.getAccountNr(), request);
    }

    @GetMapping("lesson5/2/{accountNr}") //2. Konto saldo
    public String saldo(@PathVariable("accountNr") String accountNr) {
        return "Konto saldo on " + accountBalanceMap.get(accountNr).getBalance() + " EUR.";
    }

    @PutMapping("lesson5/3/{accountNr}") //3. Lae raha
    public void laeRaha(@PathVariable("accountNr") String accountNr,
                        @RequestBody BankManagerClass request) {
        if (accountBalanceMap.get(accountNr).isLocked() == false) {
            Double balance = accountBalanceMap.get(accountNr).getBalance() + request.getBalance();
            accountBalanceMap.get(accountNr).setBalance(balance);
        } else {
            System.out.println("Konto on lukus, ei saa laadida raha");
        }
    }

    @PutMapping("lesson5/4/{accountNr}") //4. Maha raha
    public void mahaRaha(@PathVariable("accountNr") String accountNr,
                         @RequestBody BankManagerClass request) {
        if (accountBalanceMap.get(accountNr).isLocked() == false) {
            Double balance = accountBalanceMap.get(accountNr).getBalance() - request.getBalance();
            accountBalanceMap.get(accountNr).setBalance(balance);
        } else {
            System.out.println("Konto on lukus, ei saa võtta raha");
        }
    }

    @PutMapping("lesson5/5/{accountNr}/{accountNr2}")
    public void transfer(@PathVariable("accountNr") String accountNr,
                         @PathVariable("accountNr2") String accountNr2,
                         @RequestBody BankManagerClass request) {
        if (accountBalanceMap.get(accountNr).isLocked() == false &&
                accountBalanceMap.get(accountNr2).isLocked() == false) {
            Double balance = accountBalanceMap.get(accountNr).getBalance() - request.getBalance();
            Double balance2 = accountBalanceMap.get(accountNr2).getBalance() + request.getBalance();
            accountBalanceMap.get(accountNr).setBalance(balance);
            accountBalanceMap.get(accountNr2).setBalance(balance2);
        } else {
            System.out.println("Konto on lukus, ei saa kanda raha");
        }
    }

    @PutMapping("lesson5/6/{accountNr}") //6. Konto lukku
    public void lukku(@PathVariable("accountNr") String accountNr,
                      @RequestBody BankManagerClass request) {
        if (accountBalanceMap.get(accountNr).isLocked() == false) {
            accountBalanceMap.get(accountNr).setLocked(true);
        } else {
            System.out.println("Konto on juba lukus");
        }
    }
    @PutMapping("lesson5/7/{accountNr}") //7. Konto lukku
    public void vabaks(@PathVariable("accountNr") String accountNr,
                      @RequestBody BankManagerClass request) {
        if (accountBalanceMap.get(accountNr).isLocked() == true) {
            accountBalanceMap.get(accountNr).setLocked(false);
        } else {
            System.out.println("Konto on juba avatud");
        }
    }
}

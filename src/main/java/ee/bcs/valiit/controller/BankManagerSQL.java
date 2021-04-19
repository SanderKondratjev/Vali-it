package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class BankManagerSQL {

    public HashMap<String, BankManagerClass> accountBalanceMap = new HashMap<>();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {

    }

    @GetMapping("banksql")
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

    @PostMapping("banksql/1") // 1. Loo konto
    public void looKonto(@RequestBody BankManagerClass request) {
        String sql = "INSERT INTO customers(account_nr, first_name, last_name, balance, email) " +
                "VALUES(:dbAccountNr, :dbFirstName, :dbLastName, :dbBalance, :dbEmail)";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", request.getAccountNr());
        paraMap.put("dbFirstName", request.getFirstName());
        paraMap.put("dbLastName", request.getLastName());
        paraMap.put("dbBalance", request.getBalance());
        paraMap.put("dbEmail", request.getEmail());
        jdbcTemplate.update(sql, paraMap);
    }

    @GetMapping("banksql/2/{accountNr}") //2. Konto saldo
    public String saldo(@PathVariable("accountNr") String accountNr) {
        String sql = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", accountNr);
        Double balance = jdbcTemplate.queryForObject(sql, paraMap, Double.class);
        return "Konto saldo on " + balance + " EUR.";
    }

    @PutMapping("banksql/3/{accountNr}") //3. Lae raha
    public void laeRaha(@PathVariable("accountNr") String accountNr,
                        @RequestBody BankManagerClass request) {

        if (request.getBalance() > 0) {
            String lae = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr";
            Map<String, Object> paraMap1 = new HashMap<>();
            paraMap1.put("balance", request.getBalance());
            paraMap1.put("dbAccountNr", accountNr);
            Double vanaSaldo = jdbcTemplate.queryForObject(lae, paraMap1, Double.class);

            String laeSumma = "UPDATE customers SET balance = :balance WHERE account_nr = :dbAccountNr";
            String uusSaldo = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr";
            Map<String, Object> paraMap2 = new HashMap<>();
            paraMap2.put("dbAccountNr", accountNr);
            paraMap2.put("balance", request.getBalance() + vanaSaldo);
            jdbcTemplate.update(laeSumma, paraMap2);
            Double balance = jdbcTemplate.queryForObject(uusSaldo, paraMap2, Double.class);

            System.out.println("Laadisid kontole " + accountNr + " " + request.getBalance() +
                    ", uuendatud saldo on " + balance);
        }
        //System.out.println("Konto on lukus, ei saa laadida raha");
    }

    @PutMapping("banksql/4/{accountNr}") //4. Maha raha
    public void mahaRaha(@PathVariable("accountNr") String accountNr,
                         @RequestBody BankManagerClass request) {
        if (request.getBalance() > 0) {
            String maha = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr";
            Map<String, Object> paraMap1 = new HashMap<>();
            paraMap1.put("balance", request.getBalance());
            paraMap1.put("dbAccountNr", accountNr);
            Double vanaSaldo = jdbcTemplate.queryForObject(maha, paraMap1, Double.class);

            String mahaSumma = "UPDATE customers SET balance = :balance WHERE account_nr = :dbAccountNr";
            String uusSaldo = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr";
            Map<String, Object> paraMap2 = new HashMap<>();
            paraMap2.put("dbAccountNr", accountNr);
            paraMap2.put("balance", vanaSaldo - request.getBalance());
            jdbcTemplate.update(mahaSumma, paraMap2);
            Double balance = jdbcTemplate.queryForObject(uusSaldo, paraMap2, Double.class);

            System.out.println("Võtsid kontolt " + accountNr + " " + request.getBalance() +
                    ", uuendatud saldo on " + balance);
        }
    }

    @PutMapping("banksql/5/{accountNr}/{accountNr2}")
    public void transfer(@PathVariable("accountNr") String accountNr,
                         @PathVariable("accountNr2") String accountNr2,
                         @RequestBody BankManagerClass request) {
        if (request.getBalance() > 0) {
            String konto1 = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr";
            Map<String, Object> paraMap1 = new HashMap<>();
            paraMap1.put("balance", request.getBalance());
            paraMap1.put("dbAccountNr", accountNr);
            Double vanaSaldo1 = jdbcTemplate.queryForObject(konto1, paraMap1, Double.class);

            String konto2 = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr2";
            Map<String, Object> paraMap2 = new HashMap<>();
            paraMap2.put("balance", request.getBalance());
            paraMap2.put("dbAccountNr2", accountNr2);
            Double vanaSaldo2 = jdbcTemplate.queryForObject(konto2, paraMap2, Double.class);

            String laeSumma = "UPDATE customers SET balance = :balance WHERE account_nr = :dbAccountNr";
            String mahaSumma = "UPDATE customers SET balance = :balance WHERE account_nr = :dbAccountNr2";
            String uusSaldo = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr2";
            Map<String, Object> paraMap3 = new HashMap<>();
            paraMap3.put("dbAccountNr", accountNr);
            Map<String, Object> paraMap4 = new HashMap<>();
            paraMap4.put("dbAccountNr2", accountNr2);
            paraMap3.put("balance", vanaSaldo1 - request.getBalance());
            paraMap4.put("balance", request.getBalance() + vanaSaldo2);
            jdbcTemplate.update(laeSumma, paraMap3);
            jdbcTemplate.update(mahaSumma, paraMap4);
            Double balance = jdbcTemplate.queryForObject(uusSaldo, paraMap4, Double.class);

            System.out.println("Võtsid kontolt " + accountNr + " " + request.getBalance() +
                    ", uuendatud saldo kontol " + accountNr2 + " " + balance + " EUR.");
        }
    }

    @PutMapping("banksql/6/{accountNr}") //6. Konto lukku
    public void lukku(@PathVariable("accountNr") String accountNr) {
        String kontoLukku = "UPDATE customers SET locked = true WHERE account_nr = :dbAccountNr";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", accountNr);
        jdbcTemplate.update(kontoLukku, paraMap);
    }

    @PutMapping("banksql/7/{accountNr}") //7. Konto lukku
    public void vabaks(@PathVariable("accountNr") String accountNr) {
        String kontoLahti = "UPDATE customers SET locked = false WHERE account_nr = :dbAccountNr";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", accountNr);
        jdbcTemplate.update(kontoLahti, paraMap);
    }
}

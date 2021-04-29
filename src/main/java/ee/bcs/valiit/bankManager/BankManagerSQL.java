package ee.bcs.valiit.bankManager;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class BankManagerSQL {

    public HashMap<String, BankManagerClass> accountBalanceMap = new HashMap<>();

    @Autowired
    private BankManagerService bankManagerService;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {

    }
    @PostMapping("banksql/login")
    public String login(@RequestBody LoginRequestClass request) {
        return bankManagerService.password2(request);
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
        bankManagerService.looKonto(request);
    }
    @GetMapping("banksql/2/{accountNr}") //2. Konto saldo
    public String saldo(@PathVariable("accountNr") String accountNr) {
        return bankManagerService.saldo(accountNr);
    }

    @PutMapping("banksql/3/{accountNr}") //3. Lae raha
    public void laeRaha(@PathVariable("accountNr") String accountNr,
                        @RequestBody BankManagerClass request) {
        bankManagerService.laeRaha(accountNr, request);
    }

    @PutMapping("banksql/4/{accountNr}") //4. Maha raha
    public void mahaRaha(@PathVariable("accountNr") String accountNr,
                         @RequestBody BankManagerClass request) {
        bankManagerService.mahaRaha(accountNr, request);
    }


    @PutMapping("banksql/5/{accountNr}/{accountNr2}")
    public void transfer(@PathVariable("accountNr") String accountNr,
                         @PathVariable("accountNr2") String accountNr2,
                         @RequestBody BankManagerClass request) {
        bankManagerService.transfer(accountNr, accountNr2, request);
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

    @GetMapping("banksql/8")
    public List<BankManagerClass> getAllKontod() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, new HashMap(), new BankMangerClassRowMapper());
    }
}

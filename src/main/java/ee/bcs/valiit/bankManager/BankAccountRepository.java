package ee.bcs.valiit.bankManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankAccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void looKonto(BankManagerClass request) {
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

    public Double saaSaldo(String accountNr) {
        String sql = "SELECT balance FROM customers WHERE account_nr = :dbAccountNr";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", accountNr);
        return jdbcTemplate.queryForObject(sql, paraMap, Double.class);
    }

    public void uuendaSaldo(String accountNr, Double request) {
        String sql = "UPDATE customers SET balance = :balance WHERE account_nr = :dbAccountNr";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("balance", request);
        paraMap.put("dbAccountNr", accountNr);
        jdbcTemplate.update(sql, paraMap);
    }
}


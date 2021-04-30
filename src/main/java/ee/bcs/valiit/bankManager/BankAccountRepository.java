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
        String sql = "INSERT INTO customers(account_nr, name, balance, email) " +
                "VALUES(:dbAccountNr, :dbName, :dbBalance, :dbEmail)";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbAccountNr", request.getAccountNr());
        paraMap.put("dbName", request.getName());
        paraMap.put("dbBalance", 0.0);
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
    public String getPasswordRep(String username) {
        String sql = "SELECT password FROM users WHERE username = :dbUserName";
        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("dbUserName", username);
        return jdbcTemplate.queryForObject(sql, paraMap, String.class);
    }

    public void registerUser(LoginRequestClass request) {
        String sql = "INSERT INTO users(username, password) VALUES(:dbUsername, :dbPassword)";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("dbUsername", request.getUsername());
        paraMap.put("dbPassword", request.getPassword());
        jdbcTemplate.update(sql, paraMap);
    }
}


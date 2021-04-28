package ee.bcs.valiit.bankManager;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankMangerClassRowMapper implements RowMapper<BankManagerClass> {

    @Override
    public BankManagerClass mapRow(ResultSet resultSet, int i) throws SQLException {
        BankManagerClass response = new BankManagerClass();
        response.setAccountNr(resultSet.getString("account_nr"));
        response.setName(resultSet.getString("name"));
        response.setEmail(resultSet.getString("email"));
        response.setLocked(resultSet.getBoolean("locked"));
        response.setBalance(resultSet.getDouble("balance"));
        return response;
    }
}

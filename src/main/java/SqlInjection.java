// https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html#anatomy-of-a-typical-sql-injection-vulnerability

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.servlet.http.HttpServletRequest;

public class SqlInjection {
    public static ResultSet doQuery(HttpServletRequest request, Connection connection) throws SQLException {
        String customerName = request.getParameter("customerName");
        String query = "SELECT account_balance FROM user_data WHERE user_name = " + customerName;
        CachedRowSet results = RowSetProvider.newFactory().createCachedRowSet();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            results.populate(resultSet);
        }
        return(results);
    }
}

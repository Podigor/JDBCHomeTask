package statements;

import config.State;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Hillel1303 extends State {
    public static void getUserNameById(int userId) throws SQLException {
        ResultSet resultSet = getStatement().executeQuery("SELECT name FROM sys.hillel1303 WHERE id = "+userId+";");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }
    public static void getUsersWithDuplicatedCities() throws SQLException {
        ResultSet resultSet = getStatement().executeQuery(
                "SELECT * FROM sys.hillel1303 WHERE city in " +
                        "(SELECT city FROM sys.hillel1303 GROUP BY city HAVING COUNT(city) > 1)" +
                        " ORDER BY id;");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " +
                            resultSet.getString("name") + " " +
                            resultSet.getString("surname") + " " +
                            resultSet.getString("city") + " " +
                            resultSet.getString("date"));
        }
    }
}

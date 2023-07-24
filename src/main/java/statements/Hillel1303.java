package statements;

import config.State;
import objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Hillel1303 extends State {
    public static void getUserNameById(int userId) throws SQLException {
        ResultSet resultSet = getStatement().executeQuery("SELECT name FROM sys.hillel1303 WHERE id = "+userId+";");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }
    public static List<User> getUsersListWithDuplicatedCities()  {
        ResultSet resultSet;
        List<User> list=new ArrayList<>();
        try {
            resultSet = getStatement().executeQuery("SELECT * FROM sys.hillel1303 WHERE city in " +
                    "(SELECT city FROM sys.hillel1303 GROUP BY city HAVING COUNT(city) > 1)" +
                            " ORDER BY city;");
            while (resultSet.next()){
                list.add(new User(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

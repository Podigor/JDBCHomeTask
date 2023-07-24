package objects;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public String id, name, surname, city, date;

    public User(ResultSet resultSet) {
        try {
            this.id = resultSet.getString("id");
            this.name = resultSet.getString("name");
            this.surname = resultSet.getString("surname");
            this.city = resultSet.getString("city");
            this.date = resultSet.getString("date");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

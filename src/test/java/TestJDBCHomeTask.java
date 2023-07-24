import objects.User;
import org.junit.Test;
import statements.Hillel1303;

import java.sql.SQLException;

public class TestJDBCHomeTask {
    @Test
    public void test1() throws SQLException {
        Hillel1303.getUserNameById(5);
    }
    @Test
    public void test2() {
        for (User l : Hillel1303.getUsersListWithDuplicatedCities()) {
            System.out.println(l.id + " " + l.name+ " " +l.surname+ " " +l.city+ " " +l.date);
        }
    }
}


import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilterRecordsTest {
    FilterRecords filterRecords = new FilterRecords();

    /**
     * This test calls the problem1 method and then compares it to the hardcoded list here, if they are the same then
     * the test passes.
     */
    @Test
    public void problem1GetAllSmiths(){
        //arrange
        User user1 = new User(2,"Alexa", "Smith", 42500.00);
        User user2 = new User(4, "Brandon", "Smith", 120000.00);
        List<User> expectedResult = new ArrayList<>();
        expectedResult.add(user1);
        expectedResult.add(user2);

        //act
        List<User> actualResult = filterRecords.problem1();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    /**
     * This test calls the problem2 method and then compares it to the hardcoded list here, if they are the same then
     * the test passes.
     */
    @Test
    public void problem2SalaryGreaterThan(){
        //arrange
        User user1 = new User(3,"Steve", "Jones", 99890.99);
        User user2 = new User(4, "Brandon", "Smith", 120000.00);
        List<User> expectedResult = new ArrayList<>();
        expectedResult.add(user1);
        expectedResult.add(user2);

        //act
        List<User> actualResult = filterRecords.problem2();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    /**
     * The @Before annotation runs before every test so that way we create the tables required prior to running the test
     */
    @Before
    public void beforeTest(){

        try {

            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql1 = "CREATE TABLE employee (id SERIAL PRIMARY KEY, first_name varchar(100), last_name varchar(100), salary DOUBLE PRECISION);";
            String sql2 = "INSERT INTO employee (first_name, last_name, salary) VALUES ('Steve', 'Garcia', 67400.00);";
            String sql3 = "INSERT INTO employee (first_name, last_name, salary) VALUES ('Alexa', 'Smith', 42500.00);";
            String sql4 = "INSERT INTO employee (first_name, last_name, salary) VALUES ('Steve', 'Jones', 99890.99);";
            String sql5 = "INSERT INTO employee (first_name, last_name, salary) VALUES ('Brandon', 'Smith', 120000.00);";
            String sql6 = "INSERT INTO employee (first_name, last_name, salary) VALUES ('Adam', 'Jones', 55050.50);";


            PreparedStatement ps = connection.prepareStatement(sql1 + sql2 + sql3 + sql4 + sql5 + sql6);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("failed creating table");
            e.printStackTrace();
        }
    }

    /**
     * The @After annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
     */
    @After
    public void cleanup(){

        try {

            Connection connection = ConnectionUtil.getConnection();

            String sql = "DROP TABLE IF EXISTS employee;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("dropping table");
        }
    }
}

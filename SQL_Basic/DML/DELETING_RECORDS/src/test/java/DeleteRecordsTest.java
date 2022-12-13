
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteRecordsTest {
    DeleteRecords deleteRecords = new DeleteRecords();

    /**
     * In this test we are retrieving everything in the users table to ensure that Steve Jones was successfully removed and comparing it to the hardcoded values below.
     */
    @Test
    public void deleteTest(){
        //arrange
        User user1 = new User(1,"Steve","Garcia");
        User user2 = new User(2,"Alexa", "Smith");
        User user3 = new User(4, "Brandon", "Smith");
        User user4 = new User(5, "Adam", "Jones");
        List<User> expectedResult = new ArrayList<>();
        expectedResult.add(user1);
        expectedResult.add(user2);
        expectedResult.add(user3);
        expectedResult.add(user4);

        //act
        deleteRecords.problem1();

        List<User> actualResult = new ArrayList<>();

        try {
            Connection connection = ConnectionUtil.getConnection();

            String sql = "SELECT * FROM users;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                actualResult.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

















    /**
     * The @Before annotation runs before every test so that way we create the tables required prior to running the test
     */
    @Before
    public void beforeEach(){

        try {

            Connection connection = ConnectionUtil.getConnection();
            //Write SQL logic here
            String sql1 = "CREATE TABLE users (id SERIAL PRIMARY KEY, firstname varchar(100), lastname varchar(100));";
            String sql2 = "INSERT INTO users (firstname, lastname) VALUES ('Steve', 'Garcia');";
            String sql3 = "INSERT INTO users (firstname, lastname) VALUES ('Alexa', 'Smith');";
            String sql4 = "INSERT INTO users (firstname, lastname) VALUES ('Steve', 'Jones');";
            String sql5 = "INSERT INTO users (firstname, lastname) VALUES ('Brandon', 'Smith');";
            String sql6 = "INSERT INTO users (firstname, lastname) VALUES ('Adam', 'Jones');";
            PreparedStatement ps = connection.prepareStatement(sql1 + sql2 + sql3 + sql4 + sql5 + sql6);

            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    /**
     * The @After annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
     */
    @After
    public void afterEach(){
        try {
            Connection connection = ConnectionUtil.getConnection();
            String sql = "DROP TABLE users;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}

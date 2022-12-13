
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

public class CreateAViewTest {

    CreateAView createAView = new CreateAView();


    @Test
    public void problemTest(){
        createAView.problem1();

        List<User> expectedResult = new ArrayList<>();
        List<User> actualResult = new ArrayList<>();

        try {

            Connection connection = ConnectionUtil.getConnection();
            String sql = "SELECT * FROM firstname_lastname;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                actualResult.add(new User(rs.getString(1), rs.getString(2)));
            }

            String sql2 = "SELECT firstname, lastname FROM site_user;";

            ps = connection.prepareStatement(sql2);

            rs = ps.executeQuery();

            while(rs.next()){
                expectedResult.add(new User(rs.getString(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
            Assert.fail();
        }

        Assert.assertEquals(expectedResult,actualResult);
    }


















    /**
     * The @Before annotation runs before every test so that way we create the tables required prior to running the test
     */
    @Before
    public void beforeEach(){
        try {

            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql1 = "CREATE TABLE site_user (id SERIAL PRIMARY KEY, firstname varchar(100), lastname varchar(100), age int);";
            String sql2 = "INSERT INTO site_user (firstname, lastname, age) VALUES ('Steve', 'Garcia', 23);";
            String sql3 = "INSERT INTO site_user (firstname, lastname, age) VALUES ('Alexa', 'Smith', 40);";
            String sql4 = "INSERT INTO site_user (firstname, lastname, age) VALUES ('Steve', 'Jones', 29);";
            String sql5 = "INSERT INTO site_user (firstname, lastname, age) VALUES ('Brandon', 'Smith', 50);";
            String sql6 = "INSERT INTO site_user (firstname, lastname, age) VALUES ('Adam', 'Jones', 61);";

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
            String sql = "DROP TABLE site_user;";
            String sql2 = "DROP VIEW firstname_lastname;";

            PreparedStatement ps = connection.prepareStatement(sql + sql2);

            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }
}

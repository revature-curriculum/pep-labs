
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlterATableTest {
    AlterATable alterATable = new AlterATable();


    @Test
    public void problem1Test(){
        alterATable.problem1();

        try {

            Connection connection = ConnectionUtil.getConnection();
            String sql = "select lastname from users;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
            Assert.fail();
        }
    }

    @Test
    public void problem2Test(){
        alterATable.problem2();

        try {

            Connection connection = ConnectionUtil.getConnection();
            String sql = "select firstname from users;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeQuery();
            System.out.println("problem2: Column 'firstname' was not removed from the table 'users' \n");
            Assert.fail();
        } catch (SQLException e) {
        }
    }

















    /**
     * The @Before annotation runs before every test so that way we create the tables required prior to running the test
     */
    @Before
    public void beforeTest(){
        try {

            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql1 = "CREATE TABLE users (id SERIAL PRIMARY KEY, firstname varchar(100));";
            String sql2 = "INSERT INTO users (firstname) VALUES ('Kevin');";
            String sql3 = "INSERT INTO users (firstname) VALUES ('Brian');";
            String sql4 = "INSERT INTO users (firstname) VALUES ('Charles');";

            PreparedStatement ps = connection.prepareStatement(sql1 + sql2 + sql3 + sql4);

            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    /**
     * The @After annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
     */
    @After
    public void cleanup(){

        try {

            Connection connection = ConnectionUtil.getConnection();
            String sql = "DROP TABLE users;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

}

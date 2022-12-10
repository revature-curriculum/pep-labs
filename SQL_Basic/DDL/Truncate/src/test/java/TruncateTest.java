
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TruncateTest {

    private Truncate truncate = new Truncate();


    @Test
    public void problem2Test(){
        truncate.problem2();

        //Write SQL statement here
        String sql = "SELECT * FROM song;";
        int counter = 0;

        try {
            Connection connection = ConnectionUtil.getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                counter++;
            }

        } catch (SQLException e) {
            System.out.println("problem2: " + e.getMessage() + '\n');
            Assert.fail();
        }
        Assert.assertEquals(0, counter);
    }

    /**
     * The @Before annotation runs before every test so that way we create the tables required prior to running the test
     */
    @Before
    public void beforeTest(){
        try {

            Connection connection = ConnectionUtil.getConnection();

            String sql7 = "CREATE TABLE song (id SERIAL PRIMARY KEY, title varchar(100), artist varchar(100));";
            String sql8 = "INSERT INTO song (title, artist) VALUES ('Let it be', 'Beatles');";
            String sql9 = "INSERT INTO song (title, artist) VALUES ('Imagine', 'Beatles');";
            String sql10 = "INSERT INTO song (title, artist) VALUES ('Kashmir', 'Led Zeppelin');";

            PreparedStatement ps = connection.prepareStatement(sql7 + sql8 + sql9 + sql10);

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
            String sql1 = "DROP TABLE song;";

            PreparedStatement ps = connection.prepareStatement(sql1);

            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }
}

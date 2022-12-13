
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropATableTest {
    private DropATable dropATable = new DropATable();

    /**
     * The before annotation runs before every test so that way we drop the tables to avoid conflicts in future tests
     */
    @Before
    public void beforeTest(){
        try {
            Connection connection = ConnectionUtil.getConnection();
            String sql = "CREATE TABLE song (Title varchar(100), Artist varchar(100));";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("failed creating table");
        }
    }

    /**
     * The after annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
     */
    @After
    public void afterEach(){

        try {
            Connection connection = ConnectionUtil.getConnection();
            String sql = "DROP TABLE song;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {}
    }

    /**
     *  In programming we utilize try / catch constructs to catch when there are potential for errors / exceptions.
     *  For this test, if I am able to insert a song into the songs table, then the songs table was never dropped and the test should fail.
     */
    @Test
    public void dropTableTest(){
        try {
            dropATable.problem1();
            Connection connection = ConnectionUtil.getConnection();
            String sql = "INSERT INTO song (Title, Artist) VALUES ('Let it be', 'Beatles');";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("problem1: Table 'song' was not dropped.");
            Assert.fail();
        } catch (SQLException e) {}
    }
}

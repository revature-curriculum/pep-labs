
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertARecordTest {

    private InsertARecord insertARecord = new InsertARecord();

    /**
     * The @After annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
     */
    @Before
    public void beforeEach(){
        try {
            Connection connection = ConnectionUtil.getConnection();
            String sql = "CREATE TABLE song (Title varchar(100), Artist varchar(100));";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
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
        } catch (SQLException e) {
        }
    }

    /**
     * DML statements return the number of rows affected. The problem1 method will return true if the number of rows affected is greater than 0 and false if it's 0.
     * If the test returns true then the insert statement was successful and if it is false then it was unsuccessful.
     */
    @Test
    public void addSongTest(){
        Assert.assertTrue(insertARecord.problem1());
    }
}

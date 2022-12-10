
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Test;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.fail;

public class CreateATableTest {

    private CreateATable createATable = new CreateATable();

    /**
     * The @After annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
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
     * To test that the table exists, we are attempting to insert a row into the table and if table does not exist,
     * the test will fail.
     */
    @Test
    public void problem1Test(){
        try {
            createATable.problem1();
            Connection connection = ConnectionUtil.getConnection();
            String sql = "INSERT into song (Title, Artist) VALUES ('Let it Be', 'Beatles')";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
            fail();
        }
    }

}

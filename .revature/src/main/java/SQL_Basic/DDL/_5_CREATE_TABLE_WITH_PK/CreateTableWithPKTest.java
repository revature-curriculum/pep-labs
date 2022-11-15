package SQL_Basic.DDL._5_CREATE_TABLE_WITH_PK;

import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.fail;

public class CreateTableWithPKTest {

    private CreateTableWithPK createTableWithPK = new CreateTableWithPK();

    /**
     * To test that the table exists, we are attempting to insert a row into the table and if table does not exist, the test will fail.
     */
    @Test
    public void createTableSurrogateKeyTest(){

        try {
            createTableWithPK.problem1();

            Connection connection = ConnectionUtil.getConnection();

            //Notice that we are NOT manually adding a number for the primary key here. The db will do this for us because of the "SERIAL" datatype that we used.
            String sql = "INSERT into songs (Title, Artist) VALUES ('Let it Be', 'Beatles')";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
            fail();
        }
    }










    /**
     * The @After annotation runs after every test so that way we drop the tables to avoid conflicts in future tests
     */
    @After
    public void cleanup(){
        try {
            Connection connection = ConnectionUtil.getConnection();
            String sql = "DROP TABLE songs;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

}

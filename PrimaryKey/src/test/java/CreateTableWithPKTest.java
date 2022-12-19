
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.fail;

public class CreateTableWithPKTest {

    private CreateTableWithPK createTableWithPK = new CreateTableWithPK();

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
     * To test that the table exists, we are attempting to insert a row into the table and if table does not exist, the test will fail.
     */
    @Test
    public void createTableSurrogateKeyTest(){

        try {
            createTableWithPK.problem1();

            Connection connection = ConnectionUtil.getConnection();

            //Notice that we are NOT manually adding a number for the primary key here. The db will do this for us because of the "SERIAL" datatype that we used.
            String sql = "INSERT into song (id, Title, Artist) VALUES (1,'Let it Be', 'Beatles')";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
            fail();
        }



    }




    @Test
    public void TestPrimaryKeyUniqueConstraint(){

        try {
            createTableWithPK.problem1();

            Connection connection = ConnectionUtil.getConnection();

            //Notice that we are NOT manually adding a number for the primary key here. The db will do this for us because of the "SERIAL" datatype that we used.
            String sql = "INSERT into song (id, Title, Artist) VALUES (1,'Let it Be', 'Beatles');";
            String sql2 = "INSERT into song (id, Title, Artist) VALUES (1,'Imagine', 'Beatles');";

            PreparedStatement ps = connection.prepareStatement(sql + sql2);

            ps.executeUpdate();
            fail("Primary Key constraint not implemented due to unique constraint not being enforced");

        } catch (SQLException e) {
            if(!(e.getMessage().substring(0, "Unique index or primary key violation".length()).equals("Unique index or primary key violation"))){
                Assert.fail(e.getMessage());
            }
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

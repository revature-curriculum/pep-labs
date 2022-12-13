
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
            String sql = "DROP TABLE songs;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {}
    }   

    /**
     * To test that the table exists, we are attempting to insert a row into the table and if table does not exist, the test will fail.
     */
    @Test
    public void problem1Test(){
        try {
            createATable.problem1();
            Connection connection = ConnectionUtil.getConnection();
            String sql = "INSERT into songs (Title, Artist) VALUES ('Let it Be', 'Beatles')";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
            fail();
        }
    }


    /**
     * To test that the table exists, we are attempting to insert a row into the table and if table does not exist, the test will fail.
     */
    @Test
    public void problem2TableCreatedTest(){
        try {
            createATable.problem2();
            Connection connection = ConnectionUtil.getConnection();
            String sql = "INSERT into songs (Title, Artist) VALUES ('Let it be', 'Beatles');"; // testing the songs table exists with correct columns
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem2: " + e.getMessage() + '\n');
            fail();
        }
    }

    /**
     * this test will check if the unique constraint is on the title column. To do this, We are inserting the exact same record twice and if it succeeds, then the test will fail
     */
    @Test
    public void problem2UniqueConstraintOnTitleTest(){
        try {
            createATable.problem2();
            Connection connection = ConnectionUtil.getConnection();
            String sql = "INSERT into songs (Title, Artist) VALUES ('Let it be', 'Beatles');"; //testing duplicate value
            String sql2 = "INSERT into songs (Title, Artist) VALUES ('Let it be', 'Beatles');"; //testing duplicate value
            PreparedStatement ps = connection.prepareStatement(sql + sql2);
            ps.executeUpdate();

            System.out.println("problem2: UNIQUE constraint not added to 'title' column\n");
            fail();

        } catch (SQLException e) {
            if(e.getMessage().contains("Table \"SONGS\" not found")){
                System.out.println("problem2: Table SONGS not found");
                fail();
            }
        }
    }

    /**
     * this test will check if the NOT NULL constraint is on the title column. To do this, We are inserting a record that has a null value and if it succeeds, then the test will fail
     */
    @Test
    public void problem2NotNullConstraintOnTitleTest(){
        try {
            createATable.problem2();
            Connection connection = ConnectionUtil.getConnection();
            String sql = "INSERT into songs (Title, Artist) VALUES (NULL, 'Beatles');";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("problem2: NOT NULL constraint not added to 'title' column\n");
            fail();
        } catch (SQLException e) {
            if(e.getMessage().contains("Table \"SONGS\" not found")){
                System.out.println("problem2: Table SONGS not found");
                fail();
            }
        }
    }

    /**
     * this test will check if the NOT NULL constraint is on the artist column. To do this, We are inserting a record that has a null value and if it succeeds, then the test will fail
     */
    @Test
    public void problem2NotNullConstraintOnArtistTest(){
        try {
            createATable.problem2();
            Connection connection = ConnectionUtil.getConnection();
            String sql = "INSERT into songs (Title, Artist) VALUES ('Imagine', NULL);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("problem2: NOT NULL constraint was not added to 'artist' column\n");
            fail();
        } catch (SQLException e) {
            if(e.getMessage().contains("Table \"SONGS\" not found")){
                System.out.println("problem2: Table SONGS not found");
                fail();
            }
        }
    }

}

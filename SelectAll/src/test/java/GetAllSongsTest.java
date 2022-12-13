
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetAllSongsTest {

    GetAllSongs getAllSongs = new GetAllSongs();

    /**
     * The @Before annotation runs before every test so that way we create the tables required prior to running the test
     */
    @Before
    public void beforeTest(){
        try {
            Connection connection = ConnectionUtil.getConnection();
            //Write SQL logic here
            String sql1 = "CREATE TABLE song (Title varchar(100), Artist varchar(100));";
            String sql2 = "INSERT INTO song VALUES ('Let it be', 'Beatles');";
            String sql3 = "INSERT INTO song VALUES ('Hotel California', 'Eagles');";
            String sql4 = "INSERT INTO song VALUES ('Kashmir', 'Led Zeppelin');";
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
            String sql = "DROP TABLE song;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }


    /**
     * In this test we have a hardcoded version of that same list in java.
     * This test calls the method with the SQL syntax that you wrote and then compares it to the hardcoded list here, if they are the same then the test passes.
     */
    @Test
    public void getAllSongsTest(){
        //arrange
        Song song1 = new Song("Let it be", "Beatles");
        Song song2 = new Song("Hotel California", "Eagles");
        Song song3 = new Song("Kashmir", "Led Zeppelin");
        List<Song> expectedResult = new ArrayList<>();
        expectedResult.add(song1);
        expectedResult.add(song2);
        expectedResult.add(song3);

        //act
        List<Song> actualResult = getAllSongs.problem1();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}


import Util.ConnectionUtil;
import org.junit.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GroupByTest {
    private final GroupByActivity groupByActivity = new GroupByActivity();
    private static Connection conn;

    @Test
    public void problem1Test() {
        Map<String, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put("The Beatles", 2);
        expectedCounts.put("Led Zeppelin", 3);
        expectedCounts.put("The Eagles", 1);

        Map<String, Integer> resultCounts = groupByActivity.problem1();

        Assert.assertEquals(expectedCounts, resultCounts);

    }


    @BeforeClass
    public static void getConnection() {
        conn = ConnectionUtil.getConnection();
    }


    @Before
    public void setup() {
        try {
            String createTable = "CREATE TABLE song (" +
                    "id SERIAL PRIMARY KEY," +
                    "artist VARCHAR(255)," +
                    "album VARCHAR(255)," +
                    "song VARCHAR(255)" +
                    ");";
            PreparedStatement createTableStatement = conn.prepareStatement(createTable);
            createTableStatement.executeUpdate();

            String insertData = "INSERT INTO song (artist, album, song) VALUES" +
                    "('The Beatles', 'Abbey Road', 'Come Together')," +
                    "('The Beatles', 'Let It Be', 'Let It Be' )," +
                    "('Led Zeppelin', 'IV', 'Black Dog')," +
                    "('Led Zeppelin', 'Physical Graffiti', 'Kashmir' )," +
                    "('Led Zeppelin', 'IV', 'Going to California' )," +
                    "('The Eagles', 'Hotel California', 'Hotel California');";
            PreparedStatement insertDataStatement = conn.prepareStatement(insertData);
            insertDataStatement.executeUpdate();

        } catch(SQLException e) {
        }
    }

    @After
    public void cleanup() {
        try {
            conn = ConnectionUtil.getConnection();

            String dropTable = "DROP TABLE IF EXISTS song";
            PreparedStatement createTableStatement = conn.prepareStatement(dropTable);
            createTableStatement.executeUpdate();

        } catch(SQLException e) {
        }
    }

    @AfterClass
    public static void closeConnection() {
        try {
            conn.close();
        } catch(SQLException e) {
        }

    }
}

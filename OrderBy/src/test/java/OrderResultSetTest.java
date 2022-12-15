
import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.fail;

public class OrderResultSetTest {
    private final OrderResultSetActivity orderResultSetActivity = new OrderResultSetActivity();
    private Connection conn;

    @Test
    public void problem1AlphabeticalOrder() {
        try {
            List<Character> expectedList = new LinkedList<>();
            expectedList.add(new Character(3, "Jessica", "Atreides"));
            expectedList.add(new Character(1, "Leto", "Atreides"));
            expectedList.add(new Character(4, "Paul", "Atreides"));
            expectedList.add(new Character(5, "Feyd-Rautha", "Harkonnen"));
            expectedList.add(new Character(2, "Vladimir", "Harkonnen"));


            List<Character> resultList = orderResultSetActivity.problem1();

            Assert.assertEquals(expectedList, resultList);
        }catch(Exception e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
            fail();
        }
    }




    @Before
    public void beforeEach() {
        try {
            conn = ConnectionUtil.getConnection();

            String createTable = "CREATE TABLE character (" +
                    "id SERIAL PRIMARY KEY," +
                    "first_name VARCHAR(255)," +
                    "last_name VARCHAR(255)" +
                    ");";
            PreparedStatement createTableStatement = conn.prepareStatement(createTable);
            createTableStatement.executeUpdate();

            String insertData = "INSERT INTO character (first_name, last_name) VALUES" +
                    "('Leto', 'Atreides')," +
                    "('Vladimir', 'Harkonnen')," +
                    "('Jessica', 'Atreides')," +
                    "('Paul', 'Atreides')," +
                    "('Feyd-Rautha', 'Harkonnen');";
            PreparedStatement insertDataStatement = conn.prepareStatement(insertData);
            insertDataStatement.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterEach() {
        try {
            conn = ConnectionUtil.getConnection();

            String dropTable = "DROP TABLE IF EXISTS character";
            PreparedStatement createTableStatement = conn.prepareStatement(dropTable);
            createTableStatement.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

import Util.ConnectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AggregateFunctionsTest {
    private final AggregateFunctionsActivity aggregateFunctionsActivity = new AggregateFunctionsActivity();

    @Test
    public void testActivityCalculatePayroll() {
        Double expectedValue = 67400.00 + 42500.00 + 99890.99 + 120000 + 55050.50;
        Double resultValue = aggregateFunctionsActivity.problem1();

        Assert.assertEquals(expectedValue, resultValue);

    }

    @Test
    public void testActivityCountTheSmiths() {
        int expectedValue = 2;
        int resultValue = aggregateFunctionsActivity.problem2();

        Assert.assertEquals(expectedValue, resultValue);

    }

    @Test
    public void testActivityFindMinSalary() {
        Double expected = 42500.00;
        Double result = aggregateFunctionsActivity.problem3();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testActivityFindMaxSalary() {
        Double expected = 120000.00;
        Double result = aggregateFunctionsActivity.problem4();

        Assert.assertEquals(expected, result);
    }



















    @Before
    public void beforeEach() {
        try {
            Connection conn = ConnectionUtil.getConnection();

            String createTable = "CREATE TABLE employee (" +
                    "id SERIAL PRIMARY KEY," +
                    "first_name VARCHAR(255)," +
                    "last_name VARCHAR(255)," +
                    "salary DOUBLE PRECISION" +
                    ");";
            PreparedStatement createTableStatement = conn.prepareStatement(createTable);
            createTableStatement.executeUpdate();

            String insertData = "INSERT INTO employee (first_name, last_name, salary) VALUES" +
                    "('Steve', 'Garcia', 67400.00)," +
                    "('Alexa', 'Smith', 42500.00)," +
                    "('Steve', 'Jones', 99890.99)," +
                    "('Brandon', 'Smith', 120000)," +
                    "('Adam', 'Jones', 55050.50);";
            PreparedStatement insertDataStatement = conn.prepareStatement(insertData);
            insertDataStatement.executeUpdate();

        } catch(SQLException e) {
        }
    }

    @After
    public void afterEach() {
        try {
            Connection conn = ConnectionUtil.getConnection();

            String dropTable = "DROP TABLE IF EXISTS employee";
            PreparedStatement createTableStatement = conn.prepareStatement(dropTable);
            createTableStatement.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

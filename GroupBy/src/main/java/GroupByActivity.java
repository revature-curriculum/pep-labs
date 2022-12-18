
import Util.ConnectionUtil;
import Util.FileUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * SQL sublanguage: DQL (Data Query Language)
 *
 * NOTE: Before attempting this activity, you should have already completed the
 * Aggregate Functions activities.
 *
 * The GROUP BY clause allows you to group your results and can be used with the ORDER BY clause. Group By is
 * used in conjunction with aggregate functions. However, you cannot group by the output of the function.
 * Recall that the output of an aggregate function is a single aggregate value.
 *
 *
 *   employee table
 *   |  id  |     employee   |   manager    |  salary  |
 *   --------------------------------------------------
 *   |1     |'Steve'         |'Dave'        |67400.00  |
 *   |2     |'Alexa'         |'Dave'        |42500.00  |
 *   |3     |'Sarah'         |'Jane'        |99890.99  |
 *   |4     |'Brandon'       |'Jane'        |120000    |
 *   |5     |'Adam'          |'Dave'        |55050.50  |
 *
 * Example: You could query the above table with the AVG() aggregate function and GROUP BY manager to find the
 * average salary of employees under that manager (then order it from greatest average salary to least):
 *      SELECT manager, AVG(salary)
 *      FROM employees
 *      GROUP BY manager
 *      ORDER BY AVG(salary) DESC
 *
 *
 * Additional Reference if needed: https://www.w3schools.com/sql/sql_groupby.asp
 *
 */
public class GroupByActivity {
    /**
     *   song table
     *   | id |     artist     |        album        |         song         |
     *   --------------------------------------------------------------------
     *   |1   |'The Beatles'   |'Abbey Road'         |'Come Together'       |
     *   |2   |'The Beatles'   |'Let It Be'          |'Let It Be'           |
     *   |3   |'Led Zeppelin'  |'IV'                 |'Black Dog'           |
     *   |4   |'Led Zeppelin'  |'Physical Graffiti'  |'Kashmir'             |
     *   |5   |'Led Zeppelin'  |'IV'                 |'Going to California' |
     *   |6   |'The Eagles'    |'Hotel California'   |'Hotel California'    |
     */

    public Map<String, Integer> problem1() {
        /**
         * Problem 1: Use the GROUP BY clause with the COUNT() aggregate function to query the song table for the
         * number of songs by each artist. Your SQL query should select both the artist column and the COUNT(song)
         * columns, while also leveraging the group by clause.
         *
         * HINT: You should avoid using the wild card (*) in your statement. All projected columns must either be used
         * in the GROUP BY clause or an aggregate function.
         */
        String sql = FileUtil.parseSQLFile("problem1.sql");

        Map<String, Integer> counts = new HashMap<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);

            while(rs.next()) {
                counts.put(rs.getString("artist"), rs.getInt("COUNT(song)"));
            }
        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }

        return counts;
    }

}

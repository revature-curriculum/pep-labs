
import Util.ConnectionUtil;
import Util.FileUtil;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * SQL sublanguage: DQL (Data Query Language)
 *
 * We looked previously at INNER JOIN where we will only see data from the tables where there is a match between the
 * columns we join ON. OUTER JOIN will return more results, including null data where the tables did not match based
 * on the columns used for joining. There are three types of OUTER JOIN: FULL, LEFT, and RIGHT.
 *
 * Important Note: There are many implementations of Oracle's SQL standard, and they often differ slightly in grammar
 * and syntax. For instance, in PostGreSQL you can preform a FULL OUTER JOIN, however the H2 database engine used for
 * these activities does not support FULL OUTER JOIN, it only supports LEFT and RIGHT OUTER JOIN.
 *
 * FULL OUTER JOIN will return results from both tables. Any rows that do not have a match between tables will have
 * missing data which will be shown as "null".
 *
 * LEFT OUTER JOIN will return all data from table_left, and any missing data from table_right will be null.
 *
 * RIGHT OUTER JOIN will return all data from table_right, and any missing data from table_left will be null.
 *
 * Example:
 *
 *  table_left                         table_right
 * | id | character |  species  |     | id | character |        catchphrase        |
 * ------------------------------     ----------------------------------------------
 * |1   |'Bugs'     |'Rabbit'   |     |1   |'Daffy'    |'Youuu're deththpicable!'  |
 * |2   |'Daffy'    |'Duck'     |     |2   |'Elmer'    |'I'm hunting wabbits.'     |
 * |3   |'Foghorn'  |'Chicken'  |     |3   |'Porky'    |'That's all folks!'        |
 *
 * Note that there is no record in the right table for Foghorn, and there is no record in the left table for
 * Porky. When we OUTER JOIN these two tables ON the character column, the missing data will be null.
 *
 *      SELECT * FROM table_left
 *      FULL OUTER JOIN table_right ON table_left.character = table_right.character
 *
 * Note: This example shows FULL OUTER JOIN which is valid in many databases, but recall that H2 does not
 * support FULL OUTER JOIN
 *
 * The output of the join would create the following result set.
 * |  id  | character |  species  |  id  | character |        catchphrase        |
 * -------------------------------------------------------------------------------
 * |1     |'Bugs'     |'Rabbit'   |1     |'Daffy'    |'Youuu're deththpicable!'  |
 * |2     |'Daffy'    |'Duck'     |2     |'Elmer'    |'I'm hunting wabbits.'     |
 * |3     |'Foghorn'  |'Chicken'  |null  |null       |null                       |
 * |null  |null       |null       |3     |'Porky'    |'That's all folks!'        |
 *
 *
 * Additional reference material if needed:
 *      - https://stackoverflow.com/questions/13997365/sql-joins-as-venn-diagram
 *      - https://www.w3schools.com/sql/sql_join_left.asp
 *      - https://www.w3schools.com/sql/sql_join_right.asp
 *
 */

public class OuterJoinActivity {
    /**
     * Consider the following tables:
     *
     *            faculty                                  students
     * | id |    teacher    |   class   |     | id |      student      |   class   |
     * ----------------------------------     --------------------------------------
     * |1   |'Mr. Tyson'    |'Physics'  |     |1   |'John Stewart'     |'Writing'  |
     * |2   |'Ms. Lovelace' |'Math'     |     |2   |'Stephen Colbert'  |'Physics'  |
     * |3   |'Mr. McCarthy' |'Writing'  |     |3   |'Samantha Bee'     |'Math'     |
     * |4   |'Ms. Goodall'  |'Biology'  |     |4   |'Aasif Mandvi'     |'Writing'  |
     *                                        |5   |'Robert Riggle'    |'Physics'  |
     *                                        |6   |'Jessica Williams' |'Art'      |
     *
     *                       textbooks
     * | id |   class   |              textbook              |
     * -------------------------------------------------------
     * |1   |'Physics'  |'Motion 101'                        |
     * |2   |'Math'     |'What Even Is Modulus Anyway?'      |
     * |3   |'Biology'  |'Lions, Tigers, and Organs 5th ed'  |
     * |4   |'Writing'  |'The Story Circle Workbook'         |
     * |5   |'Art'      |'Teenage Mutant Ninja Turtles #10'  |
     */

    public Set<ExampleEntity> problem1() {
        /**
         * Problem 1: Use a LEFT OUTER JOIN to combine the faculty and students tables using the class column
         * as the join on column.
         * Hint: You should start with "SELECT * FROM faculty"
         */

        String sql = FileUtil.parseSQLFile("problem1.sql");




        Set<ExampleEntity> results = new HashSet<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);

            while(rs.next()) {
                results.add(new ExampleEntity(rs.getString(3), rs.getString(2), rs.getString(5), ""));
            }
        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }

        return results;
    }

    public Set<ExampleEntity> problem2() {
        /**
         * Problem 2: Use a RIGHT OUTER JOIN to combine the faculty and textbooks tables using the class column
         * as the join on column.
         * Hint: You should start with "SELECT * FROM faculty"
         */

        String sql = FileUtil.parseSQLFile("problem2.sql");



        Set<ExampleEntity> results = new HashSet<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);

            while(rs.next()) {
                results.add(new ExampleEntity(rs.getString(3), rs.getString(2), "", rs.getString(6)));
            }
        } catch (SQLException e) {
            System.out.println("problem2: " + e.getMessage() + '\n');
        }

        return results;
    }
}

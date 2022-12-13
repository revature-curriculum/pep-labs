
import Util.ConnectionUtil;
import Util.FileUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL sublanguage: DML (Data Manipulation Language)
 *
 * The "DELETE" keyword is utilized to remove records based on a condition.
 *
 * The syntax for deleting records from a table is as follows:
 * DELETE FROM table_name WHERE condition;
 *
 * NOTE: Whenever you execute a DELETE statement, have a WHERE condition that identifies exactly what records you would like to delete.
 * Leaving this out will remove ALL records from the table.
 *
 * Additional resource if needed: https://www.w3schools.com/sql/sql_delete.asp
 */
public class DeleteRecords {

    /**
     *        users table:
     *        |   id  |     firstname        |        lastname        |
     *        ----------------------------------------------------------
     *        |1      |'Steve'               |'Garcia'                |
     *        |2      |'Alexa'               |'Smith'                 |
     *        |3      |'Steve'               |'Jones'                 |
     *        |4      |'Brandon'             |'Smith'                 |
     *        |5      |'Adam'                |'Jones'                 |
     */
    public void problem1(){

        /**
         * Assignment: Delete "Steve Jones" from the users table.
         */
        String sql = FileUtil.parseSQLFile("problem1.sql");

        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            s.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }
    }
}

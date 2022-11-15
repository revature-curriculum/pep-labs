package SQL_Basic.DDL._14_TRUNCATE;


import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL sublanguage: DDL (Data Definition Language)
 *
 * The truncate keyword allows us to remove all records from a table but doesn't delete the table itself.
 *
 * The syntax for truncating a table:
 * TRUNCATE TABLE table_name;
 *
 * Additional reference material if needed: https://www.w3schools.com/sql/sql_drop_table.asp
 *      The documentation in W3 schools has a TRUNCATE demo under the DROP TABLE demo.
 */
public class Truncate {

    /**
     *       users table
     *       |   id  |     firstname        |        lastname        |
     *       ----------------------------------------------------------
     *       |1      |'Steve'               |'Garcia'                |
     *       |2      |'Alexa'               |'Smith'                 |
     *       |3      |'Steve'               |'Jones'                 |
     *       |4      |'Brandon'             |'Smith'                 |
     *       |5      |'Adam'                |'Jones'                 |
     *
     */
    public void problem1(){
        /**
         * problem1: remove all the records from the table "users"
         */

        String sql = "Write SQL statement here...";



        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            s.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }
    }

    /**
     *      Songs Table Diagram:
     *      |      title        |        artist         |
     *      ---------------------------------------------
     *      |'Let it be'        |'Beatles'              |
     *      |'Imagine'          |'Beatles'              |
     *      |'Kashmir'          |'Led Zeppelin'         |
     */
    public void problem2(){
        /**
         * problem2: remove all the records from the table "songs"
         */
        String sql = "Write SQL statement here...";



        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            s.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("problem2: " + e.getMessage() + '\n');
        }
    }
}

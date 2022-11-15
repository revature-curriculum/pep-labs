package SQL_Basic.DDL._15_ALTER_A_TABLE;


import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL sublanguage: DDL (Data Definition Language)
 *
 * Let's say we created the following table:
 * users table:
 * |    id    |     firstname     |
 * --------------------------------
 * |1         |'Kevin'            |
 * |2         |'Brian'            |
 * |3         |'Charles'          |
 *
 * The users table when it was created, forgot to add the 'lastname' column.
 *
 * We could go about solving this in 2 different ways:
 * - We could remove the table completely and create the table again with the correct number of columns
 * - We can use the ALTER keyword to add a new column to the existing table. (This is what we will be looking at for this lab)
 *
 * The ALTER keyword allows us to add / remove columns and constraints on an existing table.
 *
 * The syntax for the ALTER keyword is different depending on what we want to achieve:
 *      - Adding a column:
 *          - ALTER TABLE table_name ADD column_name data_type [constraint];
 *      - Removing a column:
 *          - ALTER TABLE table_name DROP column_name;
 *
 *     NOTE: the [] in the "Adding a column" syntax means that the constraint is optional
 *
 *
 *    Additional reference material if needed: https://www.w3schools.com/sql/sql_alter.asp
 *
 */
public class AlterATable {

    /**
     *   users table:
     *   |    id    |     firstname     |
     *   --------------------------------
     *   |1         |'Kevin'            |
     *   |2         |'Brian'            |
     *   |3         |'Charles'          |
     *
     */
    public void problem1(){
        /**
         * problem1: Use the ALTER keyword to add a "lastname" column to the "users" table.
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


    public void problem2(){
        /**
         *  problem2: Use the ALTER keyword to remove the "firstname" column from the "users" table.
         */
        //Write SQL statement here
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

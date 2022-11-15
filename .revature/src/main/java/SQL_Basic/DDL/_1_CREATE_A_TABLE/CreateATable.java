package SQL_Basic.DDL._1_CREATE_A_TABLE;

import Util.ConnectionUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * SQL sublanguage: DDL (Data Definition Language)
 *
 * As of right now, all the data that we are storing into variables in java are lost when the application ends. We need a tool that will
 * allow us to persist data past the lifetime of the java application. The most common tool to achieve this is a database.
 *
 * The specific type of database we will be utilizing uses a language called SQL (Structure Query Language).
 * Before we store or retrieve any data, we need to define the format in which it is stored. SQL utilizes tables as its format.
 * This follows a similar format to a spreadsheet.
 *
 * The tables will have rows and columns:
 *      - A column defines one attribute of a table.
 *      - A row defines a one complete item in the table.
 *
 * Let's create our first SQL table.
 * The syntax for Creating a table is as follows:
 * CREATE TABLE table_name(
 *      variable_name datatype constraint,
 *      ...
 * );
 *
 * Note: there are two terms in the above syntax that we need to understand:
 * - datatype:
 *      - A datatype defines what type of data we will be stored into this specific column.
 *      - Common datatypes:
 *          - int: stores whole numbers
 *          - double precision: stores non-whole number values (Ex: 1.234)
 *          - varchar(100): stores a string of 100 characters maximum
 *          - boolean: stores true and false values
 * - constraint:
 *      - a constraint is a rule we can add to a column that the data we insert must follow.
 *      - Common Constraints:
 *          - NOT NULL: the column must have a value when inserting a record
 *          - UNIQUE: every record in a specific column must have a unique value
 *      - If a constraint that was defined is not met when inserting a record, a SQLException will be thrown.
 *
 *
 * Additional reference material if needed:
 *      - https://www.w3schools.com/sql/sql_create_table.asp
 *      - https://www.w3schools.com/sql/sql_constraints.asp
 *
 */
public class CreateATable {

    /**
     *     Songs Table Diagram:
     *     |      title        |        artist         |
     *     ---------------------------------------------
     *     |'Let it be'        |'Beatles'              |
     *     |'Hotel California' |'Eagles'               |
     *     |'Kashmir'          |'Led Zeppelin'         |
     */
    public void problem1(){
        /**
         * Assignment: Create a new table in our database called "songs" with 2 columns "title" and "artist".
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
     *
     *     Songs Table Diagram:
     *     |    title (NOT NULL and UNIQUE)        |    artist (NOT NULL)        |
     *     -----------------------------------------------------------------------
     *     |'Let it be'                            |'Beatles'                    |
     *     |'Hotel California'                     |'Eagles'                     |
     *     |'Kashmir'                              |'Led Zeppelin'               |
     */
    public void problem2(){
        /**
         * Assignment: Create the same table as above however the title column should have the NOT NULL and UNIQUE constraint and the artist column should have the NOT NULL CONSTRAINT.
         */
        String sql = "Write SQL statement here...";


        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement s = connection.prepareStatement(sql);
            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem2: " + e.getMessage() + '\n');
        }
    }

}

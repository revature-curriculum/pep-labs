package SQL_Basic.DML._3_INSERT_A_RECORD;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL sublanguage: DML (Data Manipulation Language)
 *
 * Now that we can create and drop tables, we need to be able to insert records into the table.
 *
 * The syntax for inserting a record is as follows:
 *  INSERT INTO table_name (col_1, col_2, ...col_N) VALUES (val_1, val_2, ...val_N);
 *
 *  in the above statement:
 *      - "col_1, col_2, ...col_N"  is referring to the column name of the table.
 *      - "val_1, val_2, ...val_N" is referring to the data we are trying to insert into that specific column.
 *
 * Additional reference material if needed: https://www.w3schools.com/sql/sql_insert.asp
 * */
public class InsertARecord {

    /**
     *
     *          songs Table Diagram:
     *          |      title        |        artist         |
     *          ---------------------------------------------
     *          |'Let it be'        |'Beatles'              |
     *          |'Hotel California' |'Eagles'               |
     *          |'Kashmir'          |'Led Zeppelin'         |
     *
     * Note: when inserting strings, you wrap the string in a single quote.
     * */
    public boolean problem1(){
        /**
         * Activity: Assuming the table "songs" already exists, write the sql statement that allows us to add a new record into the table "songs".
         */
        String sql = "Write SQL statement here...";


        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            return s.executeUpdate(sql) != 0;

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }

        return false;
    }
}

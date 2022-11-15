package SQL_Basic.DQL._6_SELECTING_SPECIFIC_COLUMNS;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * SQL sublanguage: DQL (Data Query Language)
 *
 * We have learned how to query all records from a table as well as filter the amount of records we get back utilizing the WHERE keyword.
 *
 * In this lab we are going to learn how to filter the amount of columns that we want returned.
 *
 * Let's take a look at the syntax to return an entire table again:
 * SELECT * FROM table_name;
 *
 * In the statement above, the * is the wildcard to retrieve all the columns in this specific table.
 * However, we can specify the columns that we want to display by the following syntax:
 * SELECT col_1, col_2, ...col_N FROM table_name;
 *
 * Additional reference material if needed: https://www.w3schools.com/sql/sql_select.asp
 */
public class FilterColumns {

    /**
     *      users table:
     *      |   id  |     firstname        |        lastname        |
     *      ----------------------------------------------------------
     *      |1      |'Steve'               |'Garcia'                |
     *      |2      |'Alexa'               |'Smith'                 |
     *      |3      |'Steve'               |'Jones'                 |
     *      |4      |'Brandon'             |'Smith'                 |
     *      |5      |'Adam'                |'Jones'                 |
     */


    public List<User> problem1(){
        /**
         * problem 1: Write the SQL statement to return only the 'firstname' column from the users table
         */
        String sql = "Write SQL statement here...";

        List<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);
            while(rs.next()){
                users.add(new User(0, rs.getString(1), null));
            }
        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }

        return users;
    }


    public List<User> problem2(){
        /**
         * problem 2: Write the SQL statement to return only the 'lastname' column from the users table
         */
        //Write SQL statement here
        String sql = "CHANGE ME";

        List<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);

            while(rs.next()){
                users.add(new User(0, null, rs.getString(1)));
            }

        } catch (SQLException e) {
            System.out.println("problem2: " + e.getMessage() + '\n');
        }

        return users;
    }


    public List<User> problem3(){
        /**
         * problem 3: Write the SQL statement to return the 'firstname' AND 'lastname' column from the users table
         */
        //Write SQL statement here
        String sql = "CHANGE ME";

        List<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);

            while(rs.next()){
                users.add(new User(0, rs.getString(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            System.out.println("problem3: " + e.getMessage() + '\n');
        }

        return users;
    }
}

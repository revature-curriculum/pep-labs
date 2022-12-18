

import Util.ConnectionUtil;
import Util.FileUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * SQL sublanguage: DQL (Data Query Language)
 *
 * Now that we know how to query all records from a table utilizing the "SELECT" keyword, it might be beneficial to filter what records are given to us from a table.
 *
 * For example lets look at the "employee" table below:
 *      employee table
 *      |  id  |   first_name   |   last_name   |  salary  |
 *      ----------------------------------------------------
 *      |1     |'Steve'         |'Garcia'       |67400.00  |
 *      |2     |'Alexa'         |'Smith'        |42500.00  |
 *      |3     |'Steve'         |'Jones'        |99890.99  |
 *      |4     |'Brandon'       |'Smith'        |120000.00 |
 *      |5     |'Adam'          |'Jones'        |55050.50  |
 *
 * Let's say we wanted to query all the records from the table that have the first name "Steve".
 *
 * The statement that will be utilized is as follows:
 * SELECT * FROM employee WHERE first_name = 'Steve';
 *
 * In the above statement, the "WHERE" keyword allows us to filter the records based on the condition defined after the keyword.
 * The condition that we specified is that the first_name column must have the value "Steve".
 *
 * This statement would have returned the following result set:
 *      |  id  |   first_name   |   last_name   |  salary  |
 *      ----------------------------------------------------
 *      |1     |'Steve'         |'Garcia'       |67400.00  |
 *      |3     |'Steve'         |'Jones'        |99890.99  |
 *
 * In addition to filtering on equality like above, we can filter on inequality with the <, >, <=, >=, and != operators.
 * We can even filter on strings that match partially, using the LIKE keyword and the '%' wildcard. Here are a few examples:
 * This will return all records where the first name starts with 'S'
 *      SELECT * FROM employees WHERE first_name LIKE 'S%'
 * This will return all the records with a salary value of less than $100,000.00
 *      SELECT * FROM employees WHERE salary < 100000.00
 *
 *
 *  Additional reference material if needed: https://www.w3schools.com/sql/sql_where.asp
 *
 */
public class FilterRecords {

    /**
     * Problem 1: Given the employee table, write a query in the problem1.sql file to retrieve all the records
     * from the employee table that have the last_name 'Smith'
     *
     *   employee table
     *   |  id  |   first_name   |   last_name   |  salary  |
     *   --------------------------------------------------
     *   |1     |'Steve'         |'Garcia'       |67400.00  |
     *   |2     |'Alexa'         |'Smith'        |42500.00  |
     *   |3     |'Steve'         |'Jones'        |99890.99  |
     *   |4     |'Brandon'       |'Smith'        |120000.00 |
     *   |5     |'Adam'          |'Jones'        |55050.50  |
     */


    public List<User> problem1(){
        /**
         *
         */
        String sql = FileUtil.parseSQLFile("problem1.sql");


        List<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);

            while(rs.next()){
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }

        return users;
    }
    /**
     * Problem 3: Given the employee table, write a query in the problem2.sql file to retrieve all the records
     * from the employee table that have a salary greater than $75000
     *
     *   employee table
     *   |  id  |   first_name   |   last_name   |  salary  |
     *   --------------------------------------------------
     *   |1     |'Steve'         |'Garcia'       |67400.00  |
     *   |2     |'Alexa'         |'Smith'        |42500.00  |
     *   |3     |'Steve'         |'Jones'        |99890.99  |
     *   |4     |'Brandon'       |'Smith'        |120000.00 |
     *   |5     |'Adam'          |'Jones'        |55050.50  |
     */
    public List<User> problem2(){

        String sql = FileUtil.parseSQLFile("problem2.sql");


        List<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);

            while(rs.next()){
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }

        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }

        return users;
    }

}

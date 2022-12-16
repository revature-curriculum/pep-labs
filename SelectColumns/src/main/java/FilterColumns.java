import Util.ConnectionUtil;
import Util.FileUtil;

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
     * problem 1: Write the SQL statement in the problem1.sql file to return only the 'firstname' column from the
     * site_user table
     *
     *      site_user table:
     *      |   id  |     firstname        |        lastname        |
     *      ----------------------------------------------------------
     *      |1      |'Steve'               |'Garcia'                |
     *      |2      |'Alexa'               |'Smith'                 |
     *      |3      |'Steve'               |'Jones'                 |
     *      |4      |'Brandon'             |'Smith'                 |
     *      |5      |'Adam'                |'Jones'                 |
     */

    public List<User> problem1(){
        String sql = FileUtil.parseSQLFile("problem1.sql");

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

}



import Util.ConnectionUtil;
import Util.FileUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL sublanguage: DDL (Data Definition Language)
 *
 * A VIEW in SQL is a virtual table that was created based on a SQL statement that was predefined.
 *
 * For example, lets say we had the following table:
 *      site_user table:
 *      |   id  |     firstname        |        lastname        |   age   |
 *      -------------------------------------------------------------------
 *      |1      |'Steve'               |'Garcia'                |23       |
 *      |2      |'Alexa'               |'Smith'                 |40       |
 *      |3      |'Steve'               |'Jones'                 |29       |
 *      |4      |'Brandon'             |'Smith'                 |50       |
 *      |5      |'Adam'                |'Jones'                 |61       |
 *
 * If we wanted to retrieve all the records with the firstname 'Steve', we can do that with the following statement:
 * SELECT * FROM site_user WHERE firstname = 'Steve';
 *
 * This statement would give us the following virtual table:
 *      virtual table:
 *      |   id  |     firstname        |        lastname        |   age   |
 *      -------------------------------------------------------------------
 *      |1      |'Steve'               |'Garcia'                |23
 *      |3      |'Steve'               |'Jones'                 |29
 *
 *
 * What we can do is put this virtual table in a view so we can query data based on the virtual table above instead of the actual table in the database.
 *
 * The syntax for creating a view is as follows:
 * CREATE VIEW view_name AS sql_statement;
 *
 *
 * So the syntax for creating the 'steve table' table above would be:
 * CREATE VIEW stevesview AS SELECT * FROM site_user WHERE firstname = 'Steve';
 *
 *
 * This is beneficial because we can now execute SQL queries on this view instead of the entire table.
 * For example if I wanted to get the average ages of all the steves, I can do that with this new view and the aggregate function AVG() like so:
 * SELECT AVG(age) from stevesview;
 *
 *
 * Additional reference material if needed: https://www.w3schools.com/sql/sql_view.asp
 *
 */
public class CreateAView {
    /**
     *      site_user table:
     *      |   id  |     firstname        |        lastname        |   age   |
     *      -------------------------------------------------------------------
     *      |1      |'Steve'               |'Garcia'                |23       |
     *      |2      |'Alexa'               |'Smith'                 |40       |
     *      |3      |'Steve'               |'Jones'                 |29       |
     *      |4      |'Brandon'             |'Smith'                 |50       |
     *      |5      |'Adam'                |'Jones'                 |61       |
     */



    public void problem1(){
        /**
         * problem1: Create a view called "firstname_lastname" in problem1.sql from the site_user table that only has the firstname and lastname columns.
         * NOTE: This table should NOT have the id and age.
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

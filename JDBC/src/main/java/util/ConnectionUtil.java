package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Singleton Design Pattern */
public class ConnectionUtil {
    private static Connection connection = null;

    private static String url = "jdbc:h2:./h2/lesson/db";
    private static String username = "sa";
    private static String password = "sa";

    public static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;
    }
}

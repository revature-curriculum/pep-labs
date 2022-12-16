package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Util {
    public static void generateTables(){
        try {
            Connection connection = ConnectionUtil.getConnection();

            String sql = "create table songs(\n" +
                            "id serial primary key,\n" +
                            "name varchar(50) unique not null,\n" +
                            "artist varchar(50) not null\n" +
                         ");";
            
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }

    public static void dropAllTables(){
        try {
            Connection connection = ConnectionUtil.getConnection();

            String sql = "drop table songs;";
            
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

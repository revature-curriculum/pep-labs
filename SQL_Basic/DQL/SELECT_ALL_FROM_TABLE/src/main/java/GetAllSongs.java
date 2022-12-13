
import Util.ConnectionUtil;
import Util.FileUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * SQL sublanguage: DQL (Data Query Language)
 *
 * In this lab we are going to learn how to retrieve all the records from a table.
 *
 * The syntax for retrieving all rows and columns from a database table looks like the following:
 * SELECT * FROM table_name;
 *
 * NOTE: the * is a wildcard character to retrieve all the columns from the table.
 *
 * Additional reference material if needed: https://www.w3schools.com/sql/sql_select.asp
 */
public class GetAllSongs {

    /**
     *  Assignment: write the SQL statement in the problem1.sql file to retrieve all the rows and columns from the
     *  table "song". The db table we will utilize for this problem is the "song" table below
     *
     *  Song Table Diagram:
     *  |      title        |        artist         |
     *  ---------------------------------------------
     *  |"Let it be"        |Beatles                |
     *  |"Hotel California" |Eagles                 |
     *  |"Kashmir"          |Led Zeppelin           |
     *
     */
    public List<Song> problem1(){

        String sql = FileUtil.parseSQLFile("problem1.sql");


        List<Song> songs = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            Statement s = connection.createStatement();
            ResultSet rs =s.executeQuery(sql);

            while(rs.next()){
                songs.add(new Song(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("problem1: " + e.getMessage() + '\n');
        }

        return songs;
    }
}

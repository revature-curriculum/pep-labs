package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * utility class to read a .sql file in Java - Do not change anything in this class
 */
public class FileUtil {
    public static String parseSQLFile(String fileName) {

        StringBuilder sql = new StringBuilder();
        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream("./" + fileName);

            //file to be scanned
            Scanner sc = new Scanner(fis);

            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                sql.append(sc.nextLine());
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
        }

        return sql.toString();
    }
}

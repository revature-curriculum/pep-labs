import Util.ConnectionUtil;
import kotlin.Pair;
import org.junit.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class InnerJoinTest {
    private final InnerJoinActivity innerJoinActivity = new InnerJoinActivity();
    private static Connection conn;

    @Test
    public void testActivityInnerJoin1() {
        Set<Pair<Integer, String>> expected = new HashSet<>();
        expected.add(new Pair<Integer, String>(2, "Stephen Colbert"));
        expected.add(new Pair<Integer, String>(3, "Samantha Bee"));
        expected.add(new Pair<Integer, String>(5, "Robert Riggle"));


        Set<Pair<Integer, String>> result = innerJoinActivity.problem1();

        Assert.assertEquals(expected, result);

    }

    @BeforeClass
    public static void beforeAll() {
        conn = ConnectionUtil.getConnection();
    }


    @Before
    public void beforeEach() {
        try {
            String facultyTable = "CREATE TABLE class (" +
                    "id SERIAL PRIMARY KEY," +
                    "teacher_name VARCHAR(255)," +
                    "class_title VARCHAR(255)" +
                    ");";
            PreparedStatement facultyTableStatement = conn.prepareStatement(facultyTable);
            facultyTableStatement.executeUpdate();

            String insertFaculty = "INSERT INTO class (teacher_name, class_title) VALUES" +
                    "('Ms. Lovelace', 'Physics')," +
                    "('Ms. Lovelace', 'Math')," +
                    "('Mr. McCarthy', 'Writing')," +
                    "('Ms. Goodall', 'Biology');";
            PreparedStatement insertFacultyData = conn.prepareStatement(insertFaculty);
            insertFacultyData.executeUpdate();


            String studentsTable = "CREATE TABLE student (" +
                    "id SERIAL PRIMARY KEY," +
                    "student_name VARCHAR(255)," +
                    "class_title VARCHAR(255)" +
                    ");";
            PreparedStatement studentsTableStatement = conn.prepareStatement(studentsTable);
            studentsTableStatement.executeUpdate();

            String insertStudents = "INSERT INTO student (student_name, class_title) VALUES" +
                    "('John Stewart', 'Writing')," +
                    "('Stephen Colbert', 'Physics')," +
                    "('Samantha Bee', 'Math')," +
                    "('Aasif Mandvi', 'Writing')," +
                    "('Robert Riggle', 'Physics')," +
                    "('Jessica Williams', 'Art');";
            PreparedStatement insertStudentsData = conn.prepareStatement(insertStudents);
            insertStudentsData.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterEach() {
        try {
            conn = ConnectionUtil.getConnection();

            String dropTable = "DROP TABLE IF EXISTS class, student";
            PreparedStatement createTableStatement = conn.prepareStatement(dropTable);
            createTableStatement.executeUpdate();

        } catch(SQLException e) {
        }
    }

    @AfterClass
    public static void afterAll() {
        try {
            conn.close();
        } catch(SQLException e) {
        }

    }
}
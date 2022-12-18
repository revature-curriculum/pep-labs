
import Util.ConnectionUtil;
import org.junit.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OuterJoinTest {
    private final OuterJoinActivity outerJoinActivity = new OuterJoinActivity();
    private static Connection conn;



    @Test
    public void activityOuterJoin1() {
        Set<ExampleEntity> expected = new HashSet<>();
        expected.add(new ExampleEntity("Physics", "Ms. Lovelace", "Robert Riggle", ""));
        expected.add(new ExampleEntity("Physics", "Ms. Lovelace", "Stephen Colbert", ""));
        expected.add(new ExampleEntity("Math", "Ms. Lovelace", "Samantha Bee", ""));
        expected.add(new ExampleEntity("Writing", "Mr. McCarthy", "Aasif Mandvi", ""));
        expected.add(new ExampleEntity("Writing", "Mr. McCarthy", "John Stewart", ""));
        expected.add(new ExampleEntity("Biology", "Ms. Goodall", null, ""));

        Set<ExampleEntity> result = outerJoinActivity.problem1();

        Assert.assertEquals(expected, result);


    }

    @Test
    public void activityOuterJoin2() {
        Set<ExampleEntity> expected = new HashSet<>();
        expected.add(new ExampleEntity("Physics", "Ms. Lovelace", "", "Motion 101"));
        expected.add(new ExampleEntity("Math", "Ms. Lovelace", "", "What even is modulus anyway?"));
        expected.add(new ExampleEntity("Biology", "Ms. Goodall", "", "Lions, Tigers, and Organs 5th ed"));
        expected.add(new ExampleEntity("Writing", "Mr. McCarthy", "", "The Story Circle Workbook"));
        expected.add(new ExampleEntity(null, null, "", "Teenage Mutant Ninja Turtles #10"));

        Set<ExampleEntity> result = outerJoinActivity.problem2();

        Assert.assertEquals(expected, result);


    }
























    @BeforeClass
    public static void beforeAll() {
        conn = ConnectionUtil.getConnection();
    }


    @Before
    public void beforeEach() {
        try {

            String dropTable = "DROP TABLE IF EXISTS class, student, textbook";
            PreparedStatement createTableStatement = conn.prepareStatement(dropTable);
            createTableStatement.executeUpdate();


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


            String textbooksTable = "CREATE TABLE textbook (" +
                    "id SERIAL PRIMARY KEY," +
                    "class_title VARCHAR(255)," +
                    "textbook_title VARCHAR(255)" +
                    ");";
            PreparedStatement textbooksTableStatement = conn.prepareStatement(textbooksTable);
            textbooksTableStatement.executeUpdate();

            String insertTextbooks = "INSERT INTO textbook (class_title, textbook_title) VALUES" +
                    "('Physics' , 'Motion 101')," +
                    "('Math', 'What even is modulus anyway?')," +
                    "('Biology', 'Lions, Tigers, and Organs 5th ed')," +
                    "('Writing', 'The Story Circle Workbook')," +
                    "('Art', 'Teenage Mutant Ninja Turtles #10');";
            PreparedStatement insertTextbooksStatement = conn.prepareStatement(insertTextbooks);
            insertTextbooksStatement.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterEach() {
        try {
            conn = ConnectionUtil.getConnection();

            String dropTable = "DROP TABLE IF EXISTS class, student, textbook";
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
/**
 * Welcome to your first lab! This lab will identify all the different entities that you'll be creating and
 * manipulating in your code. It is purely informational, and you do NOT need to write or change anything in this
 * lab. The test cases for this lab will pass from the start.
 *
 * This file is a CLASS. A CLASS is a blueprint for generating an OBJECT. For now, you can think of a
 * Class as its own program, whose functionality gets executed whenever one of its methods gets used. A method is
 * something that an Object can 'do'. Objects contain states (variables) and behavior (methods).
 *
 */
public class GuideMain {
    /**
     * This is a main method. A main method is a method that Java is able to use as a starting point of the
     * application. You can run this method within your IDE. Most of the challenges in this repository do not
     * contain a main method, because we run our classes and methods within test cases instead. Main methods
     * always follow the same structure: public static void main(String[] args){}
     *
     * The main method will instantiate a new Guide object, produce a String using the Guide object's method
     * "guideMethod", and print to the Console what that String was.
     *
     * @param args when running a Java application from the command line, it could take arguments as additional
     *             information for running the app. We won't be using this.
     */
    public static void main(String[] args) {
//      The Guide object constructor is written to take in an int parameter, which in this case is 1.
        Guide myGuide = new Guide(1);
        String result = myGuide.guideMethod("hello from main!");
        System.out.println(result);

    }
}
/**
 *  Now, locate the test class and run its test. It should pass, and your IDE should inform you about the results
 *  of the tests.
 *  Your task will be modifying the code in the remainder of the course repo so that their test cases pass rather
 *  than fail.
 */

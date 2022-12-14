/**
 * Welcome to your first lab! This lab will identify all the different entities that you'll be creating and
 * manipulating in your code. It is purely informational, and you do NOT need to write or change anything in this
 * lab. The test cases for this lab will pass from the start.
 *
 * Java is a tricky language to learn, because performing even simple tasks can require the use of many keywords
 * and concepts which you may be unfamiliar with. Don't worry about memorizing everything here - the concepts will
 * make sense in time.
 *
 * Let's begin. This file is a CLASS. A CLASS is a blueprint for generating an OBJECT. For now, you can think of a
 * Class as its own program, whose functionality gets executed when one of its methods gets used. A method is
 * something that an Object can 'do'. Objects contain states (variables) and behavior (methods). More on methods
 * below.
 *
 * The public keyword here is an access modifiers. The access modifier affects if the class, variable,
 * or method is visible outside this class (in other files). Public is used here to designate this class as
 * accessible across the entire application.
 */
public class Guide {
    /**
     * This is a variable. It can be accessed by any of the class's methods (we refer to this as being scoped to
     * the entire class). In Java, We always need to define the kind of data that a variable could be - this
     * variable's datatype is of type 'int', one of the primitive types, which are the most basic forms of
     * information stored in binary. Ints are whole numbers. We have named this variable id, since we could use
     * this variable to tell different Guide objects apart.
     */
    int id;

    /**
     * This is a CONSTRUCTOR. Whenever we instantiate an object, a constructor is called.
     * Instantiation is process of creating a new Object, which uses this Class as a blueprint for a real
     * entity in the computer's memory which we can manipulate during the execution of the program. Usually
     * a constructor is used to define an object's fields.
     * A default constructor, with no arguments and with no behavior, can be called if none
     * other constructor is written (this is how all the other problems in this repo work, since a test must
     * create an object before it can run its methods.)
     *
     * example usage: Guide guideObject1 = new Guide(1);
     *
     * @param id We'll be setting the id of this object to whatever is passed in as a parameter
     *           to the constructor.
     */
    public Guide(int id){
        this.id = id;
    }
    /**
     *  This is a METHOD. A method is a reusable block of code that belongs to a specific object.
     *  Methods usually return something. Returning means that the method produces some value and ends.
     *  Methods oftentimes have parameters as well, which are like temporary variables that can be
     *  given to a method when it is used. If you imagine a search engine as a method, you can think of
     *  the search text as a parameter, and the results of the search as the returned value.
     *
     *  For any method other than constructors, we must define a return type. Just like variables, return
     *  types must have a data type defined. Here this is String, which is a term for text in programming
     *  languages. This method must return something that is a String. If we do not wish for this method to
     *  return anything, we could set the return type to void.
     *
     *  example usage: guideObject1.guideMethod("hello"); returns "Success from guide object 1! it says: hello"
     *
     * @param message a message variable, which will be a variable of type String. This method
     *                will use the message variable as part of the text that is returned by this method. A
     *                return can send data back to the part of the code which called this method.
     *
     * @return  some text that informs us about the guide object's id, as well as the message that was
     *          passed into this method.
     */
    public String guideMethod(String message){
//        notice how both id and message are used here to produce unique text depending on how the method was used
        return "Success from guide object " + id + "! it says: " + message ;
    }
    /**
     *  Now, locate the test class and run its test. It should pass, and your IDE should inform you about the results
     *  of the tests.
     *  Your task will be modifying the code in the remainder of the course repo so that their test cases pass rather
     *  than fail.
     */
}


/**
 * Interfaces contain methods without bodies, and classes and implement the interfaces must implement the methods.
 * Notice how this interface has a signature for a method, but it doesn't have a body (it ends with a semicolon
 * rather than curly braces.) Its code will be written by the implementing class - in this example, SampleClassC.
 * Implementing an interface can be referred to as a contractual guarantee that a class will exhibit some behavior.
 *
 * You can implement multiple interfaces, but you cannot extend multiple classes.
 *
 * You do not need to change anything in this class, it exists to show off what a Java interface looks like.
 *
 * You can read more about interfaces here: https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
 *
 * @param <T> the Object that the class that implements this interface will be compared to (usually we write
 *           the class's own name, as we typically compare objects to other objects of the same type.)
 */
public interface Comparable<T> {

    int compareTo(T data);

}

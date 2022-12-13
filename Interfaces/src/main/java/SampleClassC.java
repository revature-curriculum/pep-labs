/**
 * Notice that we are IMPLEMENTING the comparable interface, for type of ObjectToBeCompared.
 * This means that we must implement a method compareTo, otherwise the code will not compile. This compareTo method
 * was first defined in the Comparable interface, which is provided by Java by default, but is also duplicated in the
 * Comparable.java file for your viewing.
 *
 * We leverage compareTo and other functional interfaces because we may need to guarantee that an object is mutually
 * understood as exhibiting Comparable behavior if we are heavily leveraging OOP and generics. If we are creating a
 * data structure that can store any type of object, but must also sort them, we must guarantee that the objects are
 * capable of being sorted and provide a mutually understood method to compare them - compareTo.
 * Implementing an interface can be referred to as a contractual guarantee that a class will exhibit some behavior.
 *
 * You can read more about interfaces here: https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
 *
 * For this challenge, you should finish the implementation of Comparable by completing the implementation of
 * the compareTo method.
 */

public class SampleClassC implements Comparable<SampleClassC>{
    int val;
    /**
     * TODO: implement compareTo for this class
     *
     * CompareTo should return a negative value if this object's 'val' is less than another object's 'val',
     * and positive otherwise. If 'val' is equal for both objects, return 0.
     *
     * @param other another object of type SampleClassC, which we are comparing to 'this' object.
     */
    public int compareTo(SampleClassC other) {
        return 0;
    }

}

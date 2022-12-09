import java.util.Objects;

/**
 * The test cases for this class use a method called .equals which isn't written anywhere in this class. How?
 * All objects have a method called .equals() - it is inherited from the Object class, which is actually the parent
 * class of all Java classes.
 *
 * When we inherit .equals, we inherit a method that isn't very useful - however, we could override the .equals method
 * so that the .equals method we write in this class is used instead! This overriding falls under the OOP principle
 * of polymorphism, specifically runtime polymorphism (since there are situations where the exact class of an object
 * isn't known until runtime - a niche case.)
 *
 * for instance, the code:
 * public boolean equals(SampleClass other){
 *    //code here
 * }
 * Will override the default equals method when iem1.equals(iem2); is called. That equals method can be used to compare
 * 'this' object with another SampleClass named 'other'.
 *
 * Overriding equals will be the task for this challenge:
 * two objects will be considered equal if a and b are equal in both objects. .equals should take in a parameter
 * that is another ImplementEqualsMethod object, and access its version of a and b. Return true if the values of a and
 * b are equal in both objects, and false otherwise.
 *
 * Why can't we just compare objects with ==? == is referred to as a shallow comparison - it only compares the 'address'
 * of an object in memory. Two objects can have equivalent values of a,b, and c but == could resolve to false because
 * the equivalent object is located in a different place in memory. == will resolve to true only if two variables
 * represent literally the same object in memory.
 */
public class SampleClassA {
    public int a;
    public boolean b;

//    implement a .equals(SampleClass other){} method here.

}

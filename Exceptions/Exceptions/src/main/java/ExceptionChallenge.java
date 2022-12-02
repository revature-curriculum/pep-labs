public class ExceptionChallenge {
    /**
     * An exception is an unexpected event that occurs during our program.
     * Most likely, you have already encountered an Exception (ArrayIndexOutOfBounds, etc).
     * In order for our program to compile, Java needs to be prepared for how to handle an exception -
     * for instance, you could use a try/catch block to prepare some code in a 'catch' for the event that an exception
     * fires, or you can use a throws declaration to pass on an exception to whatever called the method.
     * (if an exception is thrown from main, Java will crash.) Correctly managing and throwing exceptions actually
     * makes our application more robust as we can't expect operations on files, databases, or the internet to always
     * succeed.
     *
     * Write a method to throw an exception (you will also need to add a 'throws' declaration to allow the method
     * to compile. This notifies Java that this method is *capable* of throwing an exception.) Notice also that this
     * method has a void return type - it doesn't need to return anything since the test cases are just checking
     * for a thrown exception!
     *
     * Check out this guide on throwing exceptions: https://rollbar.com/guides/java/how-to-throw-exceptions-in-java/#
     */
    public void mustThrow(){
    }
}
package Exceptions.Exceptions;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExceptionTest {
    static ExceptionChallenge ec;
    @BeforeClass
    public static void setUp(){
        ec = new ExceptionChallenge();
    }

    /**
     * This test verifies that ec.mustThrow() throws an exception.
     */
    @Test
    public void exceptionMustThrowTest(){
        Assert.assertThrows(Exception.class, ()->ec.mustThrow());
    }
}

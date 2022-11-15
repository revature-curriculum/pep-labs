package com.revature;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

import com.revature.util.CommandLine;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void problem1aTest()
    {
        String expectedResult = "Kevin";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9000/firstname/Kevin");

        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void problem1bTest()
    {
        String expectedResult = "Sam";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9000/firstname/Sam");

        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void problem2aTest()
    {
        String expectedResult = "Chase Jones";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9000/firstnameandlastname/Chase/Jones");

        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void problem2bTest()
    {
        String expectedResult = "Rachael Reese";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9000/firstnameandlastname/Rachael/Reese");

        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }
}

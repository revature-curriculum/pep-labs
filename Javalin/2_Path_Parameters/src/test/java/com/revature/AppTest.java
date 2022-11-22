package com.revature;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.util.CommandLine;

import io.javalin.Javalin;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Javalin app = JavalinSingleton.getInstance();
    
    @Before
    public void beforeEach() throws InterruptedException{
        app.start(9001);
        Thread.sleep(3000);
    }

    @After
    public void afterEach(){
        app.stop();
    }

    @Test
    public void problem1aTest()
    {
        String expectedResult = "Kevin";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9001/firstname/Kevin");

        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void problem1bTest()
    {
        String expectedResult = "Sam";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9001/firstname/Sam");

        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void problem2aTest()
    {
        String expectedResult = "Chase Jones";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9001/firstnameandlastname/Chase/Jones");

        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void problem2bTest()
    {
        String expectedResult = "Rachael Reese";

        String actualResult = CommandLine.executeCommandPrompt("curl http://localhost:9001/firstnameandlastname/Rachael/Reese");

        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
    }
}

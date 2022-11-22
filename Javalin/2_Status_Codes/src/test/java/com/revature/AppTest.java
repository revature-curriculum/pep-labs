package com.revature;

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
    public void problem1Test()
    {
        String expectedResult = "HTTP/1.1 400 Bad Request";
        String[] expectedStatus = expectedResult.split(" ");

        String actualResult = CommandLine.executeCommandPrompt("curl -I -X GET http://localhost:9001/client-side-err");
        String[] actualStatus = actualResult.split(" ");
        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedStatus[1], actualStatus[1]);
    }
}

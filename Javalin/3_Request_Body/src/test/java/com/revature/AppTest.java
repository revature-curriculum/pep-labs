package com.revature;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void prob1a()
    {
        String expectedResult = "Beatles";

        String actualResult = CommandLine.executeCommandPrompt("curl -X Post -d @./src/test/java/com/revature/util/prob1a.json http://localhost:9001/problem1");
    
        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
        
    }


    @Test
    public void prob1b()
    {
        String expectedResult = "Rolling Stones";

        String actualResult = CommandLine.executeCommandPrompt("curl -X Post -d @./src/test/java/com/revature/util/prob1b.json http://localhost:9001/problem1");
    
        if(actualResult.isEmpty()){
            Assert.fail("No response from server");
        }

        Assert.assertEquals(expectedResult, actualResult);
        
    }

    @Test
    public void prob2a()
    {
        Song expectedResult = new Song("Paint it Black", "Beatles");

        ObjectMapper om = new ObjectMapper();

        Song actualResult;
        try {
            actualResult = om.readValue(CommandLine.executeCommandPrompt("curl -X Post -d @./src/test/java/com/revature/util/prob1b.json http://localhost:9001/problem2"),Song.class);
        
            if(actualResult == null){
                Assert.fail("No response from server");
            }
    
            Assert.assertEquals(expectedResult, actualResult);
        } catch (JsonProcessingException e) {
            Assert.fail();
        }
    
        
        
    }
}

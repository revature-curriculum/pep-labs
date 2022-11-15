package com.revature;

import io.javalin.Javalin;

/**
 * If this is your first time working with path parameters, 
 *      please read the PathParameters.MD file for assistance.
 * 
 * NOTE: make sure you have the webserver running before running the tests.
 * NOTE 2: anytime you make changes, you need to rerun the server.
 */
public class App 
{

    public static void main( String[] args )
    {
        Javalin app = Javalin.create().start(9000);

        /**
         * Assignment: retrieve the firstname from the path parameter and return it in the response body.
        */
        app.get("/firstname/{first}", ctx -> {
            //write code here
        });


        /**
         * Assignment: retrieve the firstname and lastname from the path parameters and return the firstname and lastname with a space between.
         * For example if we sent the following GET request: 
         *      http://localhost:9000/firstnameandlastname/Steve/Jobs
         * Then the return in the response body should be the folowing string "Steve Jobs"
         * 
        */
        app.get("/firstnameandlastname/{first}/{last}", ctx -> {
            //write code here
        });
    }
}

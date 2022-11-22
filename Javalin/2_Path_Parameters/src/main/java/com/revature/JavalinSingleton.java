package com.revature;

import io.javalin.Javalin;

public class JavalinSingleton {

    
    /**
     * If this is your first time working with path parameters, 
     *      please read the PathParameters.MD file for assistance.
     * 
     */
    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        
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
         * Then the return in the response body should be the following string "Steve Jobs"
         * 
        */
        app.get("/firstnameandlastname/{first}/{last}", ctx -> {
            //write code here

        });

        return app;
    }
    
}

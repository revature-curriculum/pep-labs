package com.revature;

import io.javalin.Javalin;

public class JavalinSingleton {

    
    /**
     * If this is your first time working with status codes, 
     *      please read the StatusCodes.MD file for assistance.
     * 
     */
    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        
        /**
         * Assignment: return the status code for a "client side error" in the http response
         */
        app.get("/client-side-err", ctx -> {
            //write code here

        });

        return app;
    }
    
}

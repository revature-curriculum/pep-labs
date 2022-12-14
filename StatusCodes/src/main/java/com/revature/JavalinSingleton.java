package com.revature;

import io.javalin.Javalin;

public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        
        /**
         * Assignment: return the status code for a generic "client side error" in the http response
         * 
         * Note: Please refer to the "StatusCodes.MD" file for more assistance if needed.
         */
        app.get("/client-side-err", ctx -> {
        
            //write logic here

        });

        return app;
    }
    
}

package com.revature;

import io.javalin.Javalin;

public class JavalinSingleton {

    
    /**
     * Lab: Create an HTTP GET endpoint at the url: http://localhost:9000/hello that will return the string "Hello World" in the response.
     * 
     * NOTE: If this is your first time using javalin, refer to the JavalinLab.MD for assistance
     */
    public static Javalin getSingleton(){
        Javalin app = Javalin.create();
        
        //write endpoints here
        app.get("/hello", ctx -> {
            ctx.result("Hello Worl");
        });


        return app;
    }
    
}

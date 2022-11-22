package com.revature;

import io.javalin.Javalin;


public class App 
{

    /*
     * Please refer to the JavalinSingleton.java for this lab.
     */
    public static void main( String[] args )
    {
        Javalin app = JavalinSingleton.getInstance();
        
        app.start(9000);
    }
}

package com.revature;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;


public class App 
{

    /**
     * Background: A json string representing a song will be sent in this POST request with the following fields: 
     *      songName, artistName
     */
    public static void main( String[] args )
    {
        Javalin app = Javalin.create().start(9000);

        /**
         * Assignment: retrieve the song object from the request body and return the artist name.
        */
        app.post("/problem1", ctx -> {
            String jsonString = ctx.body();

            ObjectMapper om = new ObjectMapper();
    
            Song song = om.readValue(jsonString, Song.class);

            ctx.result(song.getArtistName());
        });


        /**
         * Assignment: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object in the response body
        */
        app.post("/problem2", ctx -> {
            String jsonString = ctx.body();

            ObjectMapper om = new ObjectMapper();
            Song song = om.readValue(jsonString, Song.class);

            song.setArtistName("Beatles");

            ctx.result(om.writeValueAsString(song));
        });

    }
}

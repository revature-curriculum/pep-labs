package com.revature;

import java.util.Objects;

public class Song {
    
    private String songName;
    private String artistName;


    public Song() {
    }

    public Song(String songName, String artistName) {
        this.songName = songName;
        this.artistName = artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Song songName(String songName) {
        setSongName(songName);
        return this;
    }

    public Song artistName(String artistName) {
        setArtistName(artistName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Song)) {
            return false;
        }
        Song song = (Song) o;
        return Objects.equals(songName, song.songName) && Objects.equals(artistName, song.artistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, artistName);
    }

    @Override
    public String toString() {
        return "{" +
            " songName='" + getSongName() + "'" +
            ", artistName='" + getArtistName() + "'" +
            "}";
    }

}

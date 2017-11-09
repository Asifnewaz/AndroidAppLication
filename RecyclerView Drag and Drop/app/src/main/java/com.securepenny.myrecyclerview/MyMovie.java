package com.securepenny.myrecyclerview;

/**
 * Created by R041708040 on 11/5/2017.
 */

public class MyMovie {
    private String title, genre, year;

    public MyMovie() {
    }

    public MyMovie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
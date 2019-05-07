package com.xyzmovies.moviecatalog.model;

import java.io.Serializable;

public class Movie implements Serializable {

    private String movieId;
    private String movieName;

    public Movie() {
    }


    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}

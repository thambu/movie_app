package com.dws.model;

import java.util.List;

public class MovieSummary {

    private String genre;
    private int count;
    private List<Long> movies;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getMovies() {
        return movies;
    }

    public void setMovies(List<Long> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MovieSummary{" +
                "genre='" + genre + '\'' +
                ", count=" + count +
                ", movies=" + movies +
                '}';
    }
}

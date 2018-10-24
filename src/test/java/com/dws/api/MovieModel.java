package com.dws.api;

import com.dws.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieModel {

    public Movie createMovie() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setName("Avengers");
        movie.setGenre("Action");
        movie.setImage("Avengers.jpg");
        movie.setRating("9/10");
        movie.setYear(2017);
        movie.setSummary("Action movie");
        return movie;
    }

    public List<Movie> getMoviesAsList() {
        List<Movie> movieList = new ArrayList<>();
        Movie movie1 = createMovie();
        Movie movie2 = createMovie();
        movie2.setId(2L);
        movie2.setName("Logan");
        movieList.add(movie1);
        movieList.add(movie2);
        return movieList;
    }
}

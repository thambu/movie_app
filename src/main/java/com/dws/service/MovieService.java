package com.dws.service;

import com.dws.model.Movie;
import com.dws.model.MovieSummary;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    Movie createMovie(Movie movie);

    Optional<Movie> findMovieById(long id);

    MovieSummary getMovieSummaryByGenreAndYear(String genre, int year);

}

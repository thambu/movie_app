package com.dws.service;

import com.dws.model.Movie;
import com.dws.model.MovieSummary;

import java.util.Optional;


public interface MovieService {

    Movie createMovie(Movie movie);

    Movie findMovieById(Long id);

    Movie findMovieByName(String name);

    MovieSummary getMovieSummaryByGenreAndYear(String genre, Integer year);

}

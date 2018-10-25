package com.dws.service;

import com.dws.model.Movie;
import com.dws.model.MovieSummary;
import com.dws.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findMovieById(long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie findMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public MovieSummary getMovieSummaryByGenreAndYear(String genre, int year) {
        List<Movie> movieList = movieRepository.findByGenreAndYear(genre, year);
        MovieSummary movieSummary = new MovieSummary();
        movieSummary.setGenre(genre);
        movieSummary.setCount(movieList.size());
        movieSummary.setMovies(movieList.stream().map(movie -> movie.getId()).collect(Collectors.toList()));
        return movieSummary;
    }
}

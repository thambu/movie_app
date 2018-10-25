package com.dws.service;

import com.dws.exception.ResourceNotFoundException;
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
    public Movie findMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            throw new ResourceNotFoundException("Movie", "id", id);
        } else {
            return movie.get();
        }
    }

    @Override
    public Movie findMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public MovieSummary getMovieSummaryByGenreAndYear(String genre, Integer year) {
        List<Movie> movieList = movieRepository.findByGenreAndYear(genre, year);
        MovieSummary movieSummary = new MovieSummary();
        movieSummary.setGenre(genre);
        movieSummary.setCount(movieList.size());
        movieSummary.setMovies(movieList.stream().map(movie -> movie.getId()).collect(Collectors.toList()));
        return movieSummary;
    }
}

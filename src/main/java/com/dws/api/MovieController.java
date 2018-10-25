package com.dws.api;

import com.dws.exception.ResourceNotFoundException;
import com.dws.model.Movie;
import com.dws.model.MovieSummary;
import com.dws.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Movie Controller for getting all movies and by selection criteria.
 */
@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    /**
     * Get All Movies.
     */
    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody final Movie movie) {
        movieService.createMovie(movie);
        Movie createdMovie = movieService.findMovieByName(movie.getName());
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    /**
     * Get Movie by Id.
     */
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@Valid @PathVariable(value = "id") Long id) {
        return movieService.findMovieById(id);
    }

    /**
     * Get Movie summary by Genre and Year.
     */
    @RequestMapping(value = "/movies/{genre}/{year}", method = RequestMethod.GET)
    public MovieSummary getMovieSummaryByGenreAndYear(@Valid @PathVariable(value = "genre") final String genre,
                                                      @Valid @PathVariable(value = "year") final Integer year) {
        return movieService.getMovieSummaryByGenreAndYear(genre, year);
    }

}

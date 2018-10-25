package com.dws.service;

import com.dws.api.MovieModel;
import com.dws.model.Movie;
import com.dws.model.MovieSummary;
import com.dws.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock
    private MovieRepository movieRepositoryMock;

    private MovieModel movieModel;

    @Before
    public void setUp() {
        movieModel = new MovieModel();
    }

    @Test
    public void createMovie() {
        Movie movie = movieModel.createMovie();
        when(movieRepositoryMock.save(movie)).thenReturn(movie);
        Movie movieCreated = movieService.createMovie(movie);
        Assert.assertNotNull(movieCreated);
    }

    @Test
    public void findById() {
        Optional<Movie> movie = Optional.of(movieModel.createMovie());
        when(movieRepositoryMock.findById(1L)).thenReturn(movie);
        Optional<Movie> movieReturned = movieService.findMovieById(1L);
        Assert.assertNotNull(movieReturned);
        Movie movieObj = movieReturned.get();
        Assert.assertEquals(Long.valueOf(1), movieObj.getId());
        Assert.assertEquals("Action", movieObj.getGenre());
        Assert.assertEquals("Avengers", movieObj.getName());
        Assert.assertEquals("Avengers.jpg", movieObj.getImage());
        Assert.assertEquals(Integer.valueOf(2017), movieObj.getYear());

    }

    @Test
    public void findByName() {
        Movie movie = movieModel.createMovie();
        when(movieRepositoryMock.findByName("Avengers")).thenReturn(movie);
        Movie movieReturned = movieService.findMovieByName("Avengers");
        Assert.assertNotNull(movieReturned);
        Assert.assertEquals(Long.valueOf(1), movieReturned.getId());
        Assert.assertEquals("Action", movieReturned.getGenre());
        Assert.assertEquals("Avengers", movieReturned.getName());
        Assert.assertEquals("Avengers.jpg", movieReturned.getImage());
        Assert.assertEquals(Integer.valueOf(2017), movieReturned.getYear());

    }

    @Test
    public void getMovieSummaryByGenreAndYear() {
        MovieModel movieModel = new MovieModel();
        List<Movie> movieList = movieModel.getMoviesAsList();
        when(movieRepositoryMock.findByGenreAndYear("Action", 2017)).thenReturn(movieList);
        MovieSummary movieSummary = movieService.getMovieSummaryByGenreAndYear("Action", 2017);
        Assert.assertEquals("Action", movieSummary.getGenre());
        Assert.assertEquals(2, movieSummary.getCount());
    }

}
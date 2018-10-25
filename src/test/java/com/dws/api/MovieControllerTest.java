package com.dws.api;

import com.dws.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

public class MovieControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createMovie() throws Exception {
        String uri = "/movies";
        Movie movie = movieModel.createMovie();

        String inputJson = super.mapToJson(movie);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        assertEquals(HttpStatus.CREATED.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void createMovie_field_null_return_error() throws Exception {
        String uri = "/movies";
        Movie movie = movieModel.createMovie();
        movie.setName(null);

        String inputJson = super.mapToJson(movie);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void createMovie_field_blank_return_error() throws Exception {
        String uri = "/movies";
        Movie movie = movieModel.createMovie();
        movie.setName("");

        String inputJson = super.mapToJson(movie);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    public void getMovieById() throws Exception {
        String uri = "/movies";
        long id = 1L;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri + "/" + id)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void getMovieById_not_found_return_error() throws Exception {
        String uri = "/movies";
        long id = 100L;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri + "/" + id)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void getMovieSummaryByGenreAndYear() throws Exception {
        String uri = "/movies";
        String genre = "Action";
        int year = 2017;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri + "/" + genre + "/" + year)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
}
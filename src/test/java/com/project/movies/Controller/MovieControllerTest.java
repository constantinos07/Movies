package com.project.movies.Controller;

import com.project.movies.Entity.Movie;
import com.project.movies.Service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
@WithMockUser
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieServiceMock;

    private MovieController movieController;
    private Movie movie;
    private List<Movie> movieList;

    @Before
    public void setup() {
        movieController = new MovieController(movieServiceMock);
        movieList = new ArrayList<>();
        movie = new Movie();
        movie.setId(1);
        movie.setGenre("Crime");
        movie.setMovieName("The Perfect Movie");
        movie.setPlot("Very interesting plot");
        movie.setRating(5);
        movie.setReleaseYear(2010);
        movieList.add(movie);
    }

    @Test
    public void getMovieListContentsSuccessfully() throws Exception {
        when(movieServiceMock.getAllMovies()).thenReturn(movieList);
        MvcResult mvcResult = mockMvc.perform(get("/movie/list"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();
        assertTrue(responseContent.contains("Crime"));
        assertTrue(responseContent.contains("The Perfect Movie"));
        assertTrue(responseContent.contains("2010"));
    }

    @Test
    public void showFormForNewMovieSuccessfully() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/movie/showFormForNewMovie"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();
        assertTrue(responseContent.contains("Save Movie"));
        assertTrue(responseContent.contains("Name"));
        assertTrue(responseContent.contains("Release Year"));
        assertTrue(responseContent.contains("Genre"));
        assertTrue(responseContent.contains("Plot"));
        assertTrue(responseContent.contains("Rating"));
    }

    @Test
    public void showFormForMovieUpdateSuccessfully() throws Exception {
        when(movieServiceMock.getMovie(1)).thenReturn(movie);
        MvcResult mvcResult = mockMvc.perform(get("/movie/showFormForMovieUpdate")
                .param("movieId", String.valueOf(1)))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();
        assertTrue(responseContent.contains("Save Movie"));
        assertTrue(responseContent.contains("Crime"));
        assertTrue(responseContent.contains("The Perfect Movie"));
        assertTrue(responseContent.contains("Very interesting plot"));
        assertTrue(responseContent.contains("2010"));
    }
}

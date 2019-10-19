package com.project.movies.Service;

import com.project.movies.Entity.Movie;
import com.project.movies.Exception.MovieNotFoundException;
import com.project.movies.dao.MovieDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @Mock
    private MovieDAO movieDAOMock;
    @Mock
    private Movie movieMock;

    private static final int MOVIE_ID = 1;
    private MovieService movieService;

    @Before
    public void setup() {
        movieService = new MovieService(movieDAOMock);
    }

    @Test
    public void retrievesMovieSuccessfullyWhenMovieIsRegistered() throws Exception {
        when(movieDAOMock.findMovieById(MOVIE_ID)).thenReturn(Optional.of(movieMock));
        assertNotNull(movieService.getMovie(MOVIE_ID));
    }

    @Test (expected = MovieNotFoundException.class)
    public void getMovieThrowsExceptionWhenMovieIsNotRegistered() throws Exception {
        movieService.getMovie(- MOVIE_ID);
    }

    @Test
    public void retrievesAllMoviesSuccessfully() {
        when(movieDAOMock.getMovies()).thenReturn(Collections.singletonList(movieMock));
        assertNotNull(movieService.getAllMovies());
    }
}

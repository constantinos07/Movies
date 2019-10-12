package com.project.movies.Service;

import com.project.movies.Entity.Movie;
import com.project.movies.dao.MovieDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
    public void findsMovieSuccessfullyWhenMovieIsRegistered() {
        when(movieDAOMock.findMovieById(MOVIE_ID)).thenReturn(Optional.of(movieMock));
        assertNotNull(movieService.findMovieById(MOVIE_ID));
    }

    @Test (expected = RuntimeException.class)
    public void findMovieThrowsExceptionWhenMovieIsNotRegistered() {
        movieService.findMovieById(- MOVIE_ID);
    }

}

package com.project.movies.Service;

import com.project.movies.Entity.Movie;
import com.project.movies.Exception.MovieNotFoundException;
import com.project.movies.dao.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieDAO movieDAO;

    @Autowired
    public MovieService(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Transactional
    public List<Movie> getAllMovies() {
        return movieDAO.getMovies();
    }

    @Transactional
    public Movie getMovie(int movieId) throws MovieNotFoundException {
        Optional<Movie> movie = movieDAO.findMovieById(movieId);

        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new MovieNotFoundException("Movie with Id:" + movieId + " does not exist");
        }
    }

    @Transactional
    public void saveMovie(Movie movie) {
        movieDAO.saveMovie(movie);
    }

    @Transactional
    public void deleteMovie(int movieId) {
        movieDAO.deleteMovieById(movieId);
    }
}

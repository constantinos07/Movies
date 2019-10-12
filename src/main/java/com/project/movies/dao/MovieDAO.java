package com.project.movies.dao;

import com.project.movies.Entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {

    List<Movie> getMovies();

    void saveMovie(Movie movie);

    void deleteMovieById(int movieId);

    Optional<Movie> findMovieById(int movieId);
}

package com.project.movies.Controller;

import com.project.movies.Entity.Movie;
import com.project.movies.Exception.MovieNotFoundException;
import com.project.movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie/{movieId}")
    public Movie getMovie(@PathVariable int movieId) throws MovieNotFoundException {
        return movieService.getMovie(movieId);
    }

    @GetMapping("/movie/list")
    public List<Movie> getMovieList() {
        return movieService.getAllMovies();
    }

    @PostMapping("/movie/save")
    public Movie saveMovie(@RequestBody Movie movie) {
        // set id to 0 forcing to save the new movie
        // instead of updating the db record
        movie.setId(0);
        movieService.saveMovie(movie);
        return movie;
    }

    @DeleteMapping("movie/{movieId}")
    public String deleteMovie(@PathVariable int movieId) throws MovieNotFoundException {
        Movie movie = movieService.getMovie(movieId);

        if (movie == null) {
            // create a custom exception
            throw new MovieNotFoundException("Movie id not found: " + movieId);
        }
        movieService.deleteMovie(movieId);
        return "Delete movie id - " + movieId;
    }

    @PutMapping("/movie")
    public Movie updateMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return movie;
    }
}

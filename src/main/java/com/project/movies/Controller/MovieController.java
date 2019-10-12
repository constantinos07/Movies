package com.project.movies.Controller;

import com.project.movies.Entity.Movie;
import com.project.movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie/{movieId}")
    public Movie getMovie(@PathVariable int movieId) {
        return movieService.findMovieById(movieId);
    }
}

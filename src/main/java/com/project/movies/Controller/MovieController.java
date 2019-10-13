package com.project.movies.Controller;

import com.project.movies.Entity.Movie;
import com.project.movies.Exception.MovieNotFoundException;
import com.project.movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public String getMovieList(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movieList";
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

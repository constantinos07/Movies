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
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list")
    public String getMovieList(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movieList";
    }

    @GetMapping("/showFormForNewMovie")
    public String showFormForNewMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @GetMapping("/showFormForMovieUpdate")
    public String showFormForMovieUpdate(@RequestParam("movieId") int id,
                                         Model model) throws MovieNotFoundException {
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movie/list";
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
}

package com.project.movies.Controller;

import com.project.movies.Entity.Movie;
import com.project.movies.Exception.MovieNotFoundException;
import com.project.movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String showFormForMovieUpdate(
            @RequestParam("movieId") int id,
             Model model) throws MovieNotFoundException {
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @PostMapping("/save")
    public String saveMovie(
            @ModelAttribute("movie") @Valid Movie movie,
            BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "movie-form";
        }
        movieService.saveMovie(movie);
        return "redirect:/movie/list";
    }

    @GetMapping("/delete")
    public String deleteMovie(@RequestParam ("movieId") int movieId) {
        movieService.deleteMovie(movieId);
        return "redirect:/movie/list";
    }
}

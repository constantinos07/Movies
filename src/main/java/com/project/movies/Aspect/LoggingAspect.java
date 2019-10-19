package com.project.movies.Aspect;

import com.project.movies.Entity.Movie;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @After("execution(* com.project.movies.Service.MovieService.saveMovie(..))")
    public void logAfterSaveMovie(JoinPoint joinPoint) {
        Movie movie = (Movie) joinPoint.getArgs()[0];
        System.out.println("******* logAfter saveMovie() *******");
        System.out.println(movie.toString());
        System.out.println("************************************");
    }

    @After("execution(* com.project.movies.Service.MovieService.deleteMovie(..))")
    public void logAfterDeleteMovie(JoinPoint joinPoint) {
        int movieId = (int) joinPoint.getArgs()[0];
        System.out.println("******* logAfter deleteMovie() *******");
        System.out.println("Removed movie with id: " + movieId);
        System.out.println("************************************");
    }
}

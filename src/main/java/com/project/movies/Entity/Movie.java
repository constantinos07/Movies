package com.project.movies.Entity;

import com.project.movies.Validation.Genre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Movie name is mandatory")
    @Column(name = "movie_name")
    private String movieName;

    @Min(value = 1900, message = "Movie release year must be greater or equal to 1900")
    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "rating")
    private double rating;

    @Genre(value = "", message = "invalid movie genre")
    @Column(name = "genre")
    private String genre;

    @NotBlank(message = "Plot is mandatory")
    @Column(name = "plot")
    private String plot;

    public Movie() {
    }

    public Movie(String movieName, int releaseYear, double rating, String genre, String plot) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.plot = plot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                ", plot='" + plot + '\'' +
                '}';
    }


}

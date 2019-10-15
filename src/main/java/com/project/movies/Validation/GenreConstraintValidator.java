package com.project.movies.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;

public class GenreConstraintValidator implements ConstraintValidator<Genre, String> {

    private static final Set<String> genreSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                "comedy",
                "sci-fi",
                "horror",
                "romance",
                "action",
                "thriller",
                "drama",
                "mystery",
                "crime",
                "animation",
                "adventure",
                "fantasy",
                "superhero")));

    @Override
    public void initialize(Genre genre) {
    }

    @Override
    public boolean isValid(String genre, ConstraintValidatorContext constraintValidatorContext) {
        if (genre != null) {
            return genreSet.contains(genre.toLowerCase());
        }
        return false;
    }
}

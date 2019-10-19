package com.project.movies.Validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GenreConstraintValidatorTest {

    private GenreConstraintValidator genreConstraintValidator;

    @Before
    public void setup() {
        genreConstraintValidator = new GenreConstraintValidator();
    }

    @Test
    public void genreIsNotValidWhenGenreIsNull() {
        String genre = null;
        boolean isValid = genreConstraintValidator.isValid(genre, null);
        assertFalse(isValid);
    }

    @Test
    public void genreIsNotValidWhenGenreIsEmpty() {
        String genre = "";
        boolean isValid = genreConstraintValidator.isValid(genre, null);
        assertFalse(isValid);
    }

    @Test
    public void genreIsValidWhenGenreExists() {
        String genre = "Comedy";
        boolean isValid = genreConstraintValidator.isValid(genre, null);
        assertTrue(isValid);
    }


}

package com.project.movies.dao;

import com.project.movies.Entity.Movie;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieDAOImp implements MovieDAO {

    private EntityManager entityManager;
    private Session session;

    @Autowired
    public MovieDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Movie> getMovies() {
        session = entityManager.unwrap(Session.class);
        Query<Movie> movieQuery = session.createQuery("from Movie", Movie.class);
        return movieQuery.getResultList();
    }

    @Override
    public void saveMovie(Movie movie) {
        session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(movie);
    }

    @Override
    public void deleteMovieById(int movieId) {
        session = entityManager.unwrap(Session.class);
        Query query= session.createQuery("delete from Movie where id =: movieId");
        query.setParameter("movieId", movieId);
        query.executeUpdate();

    }

    @Override
    public Optional<Movie> findMovieById(int movieId) {
        session = entityManager.unwrap(Session.class);

        Movie movie = session.get(Movie.class, movieId);
        if (movie == null) {
            return Optional.empty();
        } else {
            return Optional.of(movie);
        }
    }
}

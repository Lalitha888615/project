package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Movies;
import com.capg.entity.User;
import com.capg.exception.MovieNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.MoviesRepository;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;
    
    @Override
    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies getMovieById(long id) throws MovieNotFoundException{
        Movies movie;
        if(moviesRepository.findById(id).isEmpty()) {
            throw new MovieNotFoundException();
        }
        else {
            movie=moviesRepository.findById(id).get();
        }
        return movie;
        }

    @Override
    public Movies addMovie(Movies movie) {
        return moviesRepository.save(movie);
    }

    @Override
    public void updateMovie(Movies movie) {
        moviesRepository.save(movie);
    }

    @Override
    public void deleteMovie(long id) {
        moviesRepository.deleteById(id);
    }
}


//	import java.util.List;
//
//	import javax.persistence.EntityManager;
//	import javax.persistence.PersistenceContext;
//	import javax.persistence.Query;
//	import javax.transaction.Transactional;
//
//	import org.springframework.stereotype.Repository;
//
//	import com.capg.entity.Movies;
//
//	@Repository
//	@Transactional
//	public class MoviesServiceImpl implements MoviesService {
//		
//		@PersistenceContext
//		EntityManager entityManager;
//		
//		@Override
//		public List<Movies> getAllMovies() {
//			Query query = entityManager.createQuery("SELECT m FROM Movies m");
//			return query.getResultList();
//		}
//		
//		@Override
//		public Movies getMovieById(long id) {
//			return entityManager.find(Movies.class, id);
//		}
//		
//		@Override
//		public Movies addMovie(Movies movie) {
//			entityManager.persist(movie);
//			return movie;
//		}
//		
//		@Override
//		public void updateMovie(Movies movie) {
//			entityManager.merge(movie);
//		}
//		
//		@Override
//		public void deleteMovie(long id) {
//			Movies movie = entityManager.find(Movies.class, id);
//			entityManager.remove(movie);
//		}
//	}
//
//

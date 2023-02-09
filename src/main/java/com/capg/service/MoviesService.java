package com.capg.service;

import java.util.List;

import com.capg.entity.Movies;
import com.capg.exception.MovieNotFoundException;

public interface MoviesService {
	public List<Movies> getAllMovies();
	public Movies getMovieById(long id) throws MovieNotFoundException;
	public Movies addMovie(Movies movie);
	public void updateMovie(Movies movie);
	public void deleteMovie(long id);
}



package com.capg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Booking;
import com.capg.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Long>{

	List<Movies> getMovieById(long id);

}

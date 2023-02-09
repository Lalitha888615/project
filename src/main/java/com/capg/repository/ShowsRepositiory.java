package com.capg.repository;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Booking;
import com.capg.entity.Shows;

public interface ShowsRepositiory extends JpaRepository<Shows, Long>{

	Shows findByShowTimeAndMovieId(LocalTime showTime, long movieId);

	

	

}

package com.capg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	List<Booking> findByDate(LocalDate date);

	

}

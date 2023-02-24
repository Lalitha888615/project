package com.capg.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.entity.Booking;
import com.capg.exception.BookingNotFoundException;

public interface BookingService {
	public Booking addBooking(Booking booking) ;
	public List<Booking> findAll();
	public Booking findById(long id)throws BookingNotFoundException;
	public List<Booking> findByDate(LocalDate date);
	public Booking deleteBooking(long id);
}


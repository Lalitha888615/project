package com.capg.service;
import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Booking;
import com.capg.entity.User;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

   
    @Override
    public Booking findById(long id) throws BookingNotFoundException{
    Booking book;
    if(bookingRepository.findById(id).isEmpty()) {
        throw new BookingNotFoundException();
    }
    else {
        book=bookingRepository.findById(id).get();
    }
    return book;
    }

    @Override
    public List<Booking> findByDate(LocalDate date) {
        return bookingRepository.findByDate(date);
    }

    @Override
    public Booking deleteBooking(long id) {
    	Booking booking=bookingRepository.findById(id).orElse(null);
    	if(booking!=null) {
    		bookingRepository.delete(booking);
    	}
    			
        return booking;
    }
}
















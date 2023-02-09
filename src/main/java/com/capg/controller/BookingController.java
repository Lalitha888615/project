package com.capg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Booking;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

private BookingService bookingService;

@Autowired
public BookingController(BookingService bookingService) {
	this.bookingService = bookingService;
}

@PostMapping("/booking")
public Booking addBooking(@RequestBody Booking booking) {
	return bookingService.addBooking(booking);
}

@GetMapping
public List<Booking> findAll() {
	return bookingService.findAll();
}

@GetMapping("/{id}")
public ResponseEntity findById(@PathVariable long id) throws BookingNotFoundException {
    return new ResponseEntity(this.bookingService.findById(id),HttpStatus.OK);
}
//public Booking findById(@PathVariable long id) {
//	return bookingService.findById(id);
//}

@GetMapping("/date/{date}")
public List<Booking> findByDate(@PathVariable LocalDate date) {
	return bookingService.findByDate(date);
}

@DeleteMapping
public void deleteBooking(@RequestBody Booking booking) {
	bookingService.deleteBooking(booking);
}
}
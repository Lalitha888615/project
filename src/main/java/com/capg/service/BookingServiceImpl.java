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
//    public Booking findById(long id) {
//        return bookingRepository.findById(id).orElse(null);
//    }

    @Override
    public List<Booking> findByDate(LocalDate date) {
        return bookingRepository.findByDate(date);
    }

    @Override
    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }
}















//package com.capg.service;
//
//import java.time.LocalDate;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.capg.entity.Booking;
//
//@Repository
//@Transactional
//public class BookingServiceImpl implements BookingService {
//
//	@PersistenceContext
//	EntityManager entityManager;
//	
//	@Override
//	public Booking addBooking(Booking booking) {
//		entityManager.persist(booking);
//		return booking;
//	}
//
//	@Override
//	public List<Booking> findAll() {
//		Query query = entityManager.createQuery("SELECT b FROM Booking b");
//		return query.getResultList();
//	}
//
//	@Override
//	public Booking findById(long id) {
//		return entityManager.find(Booking.class, id);
//	}
//
//	@Override
//	public List<Booking> findByDate(LocalDate date) {
//		Query query = entityManager.createQuery("SELECT b FROM Booking b WHERE b.bookedDate = :date");
//		query.setParameter("date", date);
//		return query.getResultList();
//	}
//
//	@Override
//	public void deleteBooking(Booking booking) {
//		entityManager.remove(booking);
//	}
//
//}

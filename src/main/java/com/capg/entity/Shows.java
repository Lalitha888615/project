package com.capg.entity;

import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name="shows")

public class Shows {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name ="show_id")
	private long id;
	
	
	@OneToOne
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	@Column(name="showTime")
	private LocalTime showTime;
	
	@ManyToOne
	@JoinColumn(name="hall_id")
	private Hall hall;
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movies movie;
	
	public Shows() {}

	public long getId() {
		return id;
	}

	public Booking getBooking() {
		return booking;
	}

	public LocalTime getShowTime() {
		return showTime;
	}

	public Hall getHall() {
		return hall;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Shows [id=" + id + ", booking=" + booking + ", showTime=" + showTime + ", hall=" + hall + ", movie=" + movie
				+ "]";
	}

}
package com.capg.service;

import java.time.LocalTime;
import java.util.List;

import com.capg.entity.Shows;
import com.capg.exception.ShowNotFoundException;
import com.capg.exception.UserAlreadyExistsException;

public interface ShowsService {

	public Shows addShow(Shows show);
	public List <Shows> getAllShows();
	
	public Shows findShowById(long id) throws ShowNotFoundException;
	
	public Shows updateShow(Shows show) throws UserAlreadyExistsException;
	
	public void deleteShow(Shows show);
	
	public Shows findShowByShowTimeAndMovie(LocalTime showTime, long movieId);
	
}


package com.capg.controller;

import java.time.LocalTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Shows;
import com.capg.exception.ShowNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.service.ShowsService;

@RestController
public class ShowsController {
	
	@Autowired
	ShowsService showsService;
	
	@GetMapping("/shows")
	public List<Shows> getAllShows(){
		return showsService.getAllShows();
	}
	
	@PostMapping("/shows")
	public Shows addShow(@RequestBody Shows show) {
		return showsService.addShow(show);
	}
	
	@GetMapping("/shows/{id}")
	public Shows findShowById(@PathVariable long id) throws ShowNotFoundException {
        return  (this.showsService.findShowById(id));
	}
//	public Shows findShowById(@PathVariable long id) {
//		return showsService.findShowById(id);
//	}
	
	@PutMapping("/shows")
	public Shows updateShow(@RequestBody Shows show) {
		return showsService.updateShow(show);
	}
	
	@DeleteMapping("/shows/{show}")
	public void deleteShow(@PathVariable Shows show) {
		showsService.deleteShow(show);
	}
	
	@GetMapping("/shows/findbytimeandmovie/{showTime}/{movieId}")
	public Shows findShowByShowTimeAndMovie(@PathVariable LocalTime showTime, @PathVariable long movieId) {
		return showsService.findShowByShowTimeAndMovie(showTime, movieId);
	}
}

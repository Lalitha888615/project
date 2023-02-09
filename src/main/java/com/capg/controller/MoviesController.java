package com.capg.controller;

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

import com.capg.entity.Movies;
import com.capg.exception.MovieNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.service.MoviesService;

@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/movies")
    public List<Movies> getAllMovies() {
        return moviesService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity getMovieById(@PathVariable long id) throws MovieNotFoundException {
        return new ResponseEntity(this.moviesService.getMovieById(id),HttpStatus.OK);
    }
//    public Movies getMovieById(@PathVariable long id) {
//        return moviesService.getMovieById(id);
//    }

    @PostMapping("/movies")
    public Movies addMovie(@RequestBody Movies movie) {
        return moviesService.addMovie(movie);
    }

    @PutMapping("/movies")
    public void updateMovie(@RequestBody Movies movie) {
        moviesService.updateMovie(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable long id) {
        moviesService.deleteMovie(id);
    }
}

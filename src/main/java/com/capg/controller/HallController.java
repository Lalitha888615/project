package com.capg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Hall;
import com.capg.exception.HallNotFoundException;
import com.capg.service.HallService;

@RestController
@RequestMapping("/hall")
public class HallController {

    private final HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @PostMapping("/add")
    public Hall addHall(@RequestBody Hall hall) {
        return hallService.addHall(hall);
    }

    @PutMapping("/update")
    public Hall updateHall(@RequestBody Hall hall) {
        return hallService.updateHall(hall);
    }

    @GetMapping("/{id}")
    public ResponseEntity getHallById(@PathVariable long id) throws HallNotFoundException {
        return new ResponseEntity(this.hallService.getHallById(id),HttpStatus.OK);
    }
//    public Hall getHall(@PathVariable long id) {
//        return hallService.getHallById(id);
//    }

    @GetMapping("/all")
    public List<Hall> getAllHalls() {
        return hallService.getAllHalls();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHall(@PathVariable long id) {
        hallService.deleteHall(id);
    }
}

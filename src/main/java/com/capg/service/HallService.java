package com.capg.service;
import java.util.List;

import com.capg.entity.Hall;
import com.capg.exception.HallNotFoundException;

public interface HallService {
 
 public Hall addHall(Hall hall);
 
 public Hall updateHall(Hall hall);
 
 public void deleteHall(long id);
 
 public Hall getHallById(long id)throws HallNotFoundException;
 
 public List<Hall> getAllHalls();
 
}


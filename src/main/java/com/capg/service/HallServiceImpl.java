package com.capg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Hall;
import com.capg.exception.HallNotFoundException;
import com.capg.repository.HallRepository;

@Service
public class HallServiceImpl implements HallService {
 
 @Autowired
 private HallRepository hallRepository;
 
 @Override
 public Hall addHall(Hall hall) {
   return hallRepository.save(hall);
 }
 
 @Override
 public Hall updateHall(Hall hall) {
   return hallRepository.save(hall);
 }
 
 @Override
 public void deleteHall(long id) {
   hallRepository.deleteById(id);
 }
 
 @Override
 public Hall getHallById(long id) throws HallNotFoundException{
 Hall hall;
 if(hallRepository.findById(id).isEmpty()) {
     throw new HallNotFoundException();
 }
 else {
     hall=hallRepository.findById(id).get();
 }
 return hall;
 }
// 
//   return hallRepository.findById(id).orElse(null);
// }
 
 @Override
 public List<Hall> getAllHalls() {
   return hallRepository.findAll();
 }
}

//
//	import java.util.List;
//
//	import javax.persistence.EntityManager;
//	import javax.persistence.PersistenceContext;
//	import javax.persistence.TypedQuery;
//
//	import org.springframework.stereotype.Repository;
//
//	import com.capg.entity.Hall;
//
//	@Repository
//	public class HallServiceImpl implements HallService {
//
//	 @PersistenceContext
//	 private EntityManager entityManager;
//	 
//	 @Override
//	 public Hall addHall(Hall hall) {
//	  entityManager.persist(hall);
//	  return hall;
//	 }
//	 
//	 @Override
//	 public Hall updateHall(Hall hall) {
//	  entityManager.merge(hall);
//	  return hall;
//	 }
//	 
//	 @Override
//	 public void deleteHall(long id) {
//	  Hall hall=entityManager.find(Hall.class, id);
//	  entityManager.remove(hall);
//	 }
//	 
//	 @Override
//	 public Hall getHallById(long id) {
//	  return entityManager.find(Hall.class, id);
//	 }
//	 
//	 @Override
//	 public List<Hall> getAllHalls() {
//	  TypedQuery<Hall> query=entityManager.createQuery("from Hall", Hall.class);
//	  return query.getResultList();
//	 }
//	 
//	}
//

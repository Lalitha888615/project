package com.capg.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Shows;
import com.capg.entity.User;
import com.capg.exception.ShowNotFoundException;
import com.capg.repository.ShowsRepositiory;


@Service
public class ShowsServiceImpl implements ShowsService {
    
    @Autowired
    private ShowsRepositiory showsRepository;
    
    @Override
    public Shows addShow(Shows show) {
        return showsRepository.save(show);
    }

    @Override
    public Shows findShowById(long id) throws ShowNotFoundException{
    Shows shows;
    if(showsRepository.findById(id).isEmpty()) {
        throw new ShowNotFoundException();
    }
    else {
       shows=showsRepository.findById(id).get();
    }
    return shows;
    }

    @Override
    public Shows updateShow(Shows show) {
        return showsRepository.save(show);
    }

    @Override
    public void deleteShow(Shows show) {
        showsRepository.delete(show);
    }

    @Override
    public Shows findShowByShowTimeAndMovie(LocalTime showTime, long movieId) {
        return showsRepository.findByShowTimeAndMovieId(showTime, movieId);
    }

	@Override
	public List<Shows> getAllShows() {
		
		return showsRepository.findAll();
	}

	
	
}



//	import java.time.LocalTime;
//
//	import javax.persistence.EntityManager;
//	import javax.persistence.PersistenceContext;
//	import javax.persistence.Query;
//
//	import org.springframework.stereotype.Repository;
//
//	import com.capg.entity.Shows;
//
//	@Repository
//	public class ShowsServiceImpl implements ShowsService {
//
//		@PersistenceContext
//		private EntityManager entityManager;
//		
//		@Override
//		public Shows addShow(Shows show) {
//			entityManager.persist(show);
//			return show;
//		}
//		
//		@Override
//		public Shows findShowById(long id) {
//			return entityManager.find(Shows.class, id);
//		}
//		
//		@Override
//		public Shows updateShow(Shows show) {
//			return entityManager.merge(show);
//		}
//		
//		@Override
//		public void deleteShow(Shows show) {
//			entityManager.remove(show);
//		}
//		
//		@Override
//		public Shows findShowByShowTimeAndMovie(LocalTime showTime, long movieId) {
//			Query query = entityManager.createQuery("SELECT s FROM Shows s WHERE s.showTime = :showTime AND s.movie.id = :movieId");
//			query.setParameter("showTime", showTime);
//			query.setParameter("movieId", movieId);
//			
//			return (Shows) query.getSingleResult();
//		}
//		
//	}
//
//

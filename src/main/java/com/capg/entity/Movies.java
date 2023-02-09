package com.capg.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="movies")

public class Movies {
	public Movies() {}
	public Movies(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name ="movie_id")
	private long id;
	
	@Column(name="movie_name")
	private String name;
	
//	@OneToMany(mappedBy="movie")
//	private Set<Shows> shows;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

//	public Set<Shows> getShows() {
//		return shows;
//	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public void setShows(Set<Shows> shows) {
//		this.shows = shows;
//	}
	

	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name +  "]";
	}

	

	
	
}

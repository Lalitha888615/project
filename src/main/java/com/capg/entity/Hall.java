package com.capg.entity;




import javax.persistence.*;



@Entity
@Table(name="hall")
public class Hall {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name ="hall_id")
	private long id;
	
	@Column(name="seat_number")
	private int seatNumber;
	
	
	
//	@OneToMany(mappedBy="hall")
//	private Set<Shows> shows;
	
	public Hall() {}

	public Hall(long id, int seatNumber) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
//		this.shows = shows;
	}

	public long getId() {
		return id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	

//	public Set<Shows> getShows() {
//		return shows;
//	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	

//	public void setShows(Set<Shows> shows) {
//		this.shows = shows;
//	}

	@Override
	public String toString() {
		return "Hall [id=" + id + ", seatNumber=" + seatNumber +  "]";
	}

	

}

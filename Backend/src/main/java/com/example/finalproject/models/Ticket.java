/**
 * 
 */
package com.example.finalproject.models;

import javax.persistence.*;
/**
 * @author akbar alzaini
 *
 */
@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private Integer seatNumber;
	
	@Column(length = 20)
	private Boolean cancellable;
	
	@Column(length = 20)
	private String journeyDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User passenger;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trip_schedule_id",referencedColumnName = "id")
	private TripSchedule tripSchedule;

	public Ticket(Integer seatNumber, Boolean cancellable, String journeyDate, User passenger,
			TripSchedule tripSchedule) {
		super();
		this.seatNumber = seatNumber;
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.passenger = passenger;
		this.tripSchedule = tripSchedule;
	}
	
	
	public Ticket() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Boolean getCancellable() {
		return cancellable;
	}

	public void setCancellable(Boolean cancellable) {
		this.cancellable = cancellable;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public User getPassenger() {
		return passenger;
	}

	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}

	public TripSchedule getTripSchedule() {
		return tripSchedule;
	}

	public void setTripSchedule(TripSchedule tripSchedule) {
		this.tripSchedule = tripSchedule;
	}
}

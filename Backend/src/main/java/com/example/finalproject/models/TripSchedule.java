/**
 * 
 */
package com.example.finalproject.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author akbar alzaini
 *
 */
@Entity
@Table(name = "trip_schedule")
public class TripSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String tripDate;
	
	@Column(length = 20)
	private Integer availableSeats;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trip_id",referencedColumnName = "id")
	private Trip tripDetail;
	
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "trip_shedule_tickets", 
				joinColumns = @JoinColumn(name = "trip_schedule_id"), 
				inverseJoinColumns = @JoinColumn(name = "ticket_id"))
	private Set<Ticket> ticketsSold = new HashSet<>();
	
	

	public TripSchedule(String tripDate, Integer availableSeats, Trip tripDetail) {
		super();
		this.tripDate = tripDate;
		this.availableSeats = availableSeats;
		this.tripDetail = tripDetail;
	}
	
	
	public TripSchedule() {
	}

	public Set<Ticket> getTicketsSold() {
		return ticketsSold;
	}

	public void setTicketsSold(Set<Ticket> ticketsSold) {
		this.ticketsSold = ticketsSold;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Trip getTripDetail() {
		return tripDetail;
	}

	public void setTripDetail(Trip tripDetail) {
		this.tripDetail = tripDetail;
	}
	
	
}

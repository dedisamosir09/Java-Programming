/**
 * 
 */
package com.example.finalproject.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author akbar alzaini
 *
 */
public class TripScheduleRequest {
	@JsonIgnore
	private Long id;
	 
	private Long trip_id;
	 
	private String tripDate;
	 
	private int availableSeats;
	

	public TripScheduleRequest(Long trip_id, String tripDate, int availableSeats) {
		super();
		this.trip_id = trip_id;
		this.tripDate = tripDate;
		this.availableSeats = availableSeats;
	}

	public TripScheduleRequest() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Long getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(Long trip_id) {
		this.trip_id = trip_id;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
}

package com.example.finalproject.payload.request;


public class CreateTicketRequest {

	private Integer seatNumber;
	
	private Boolean cancellable;
	
	private String JourneyDate;
	
	private Long passengerId;
	
	private Long tripScheduleId;

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
		return JourneyDate;
	}

	public void setJourneyDate(String journeyDate) {
		JourneyDate = journeyDate;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public Long getTripScheduleId() {
		return tripScheduleId;
	}

	public void setTripScheduleId(Long tripScheduleId) {
		this.tripScheduleId = tripScheduleId;
	}
	
}

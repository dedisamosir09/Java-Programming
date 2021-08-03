package com.example.finalproject.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateTripRequest {

	private int fare;
	
	@NotBlank
	@Size(max = 50)
	private String journeyTime;
	
	private Long sourceStopId;
	

	private Long destStopId;
	

	private Long busId;
	

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}

	public Long getSourceStopId() {
		return sourceStopId;
	}

	public void setSourceStopId(Long sourceStopId) {
		this.sourceStopId = sourceStopId;
	}

	public Long getDestStopId() {
		return destStopId;
	}

	public void setDestStopId(Long destStopId) {
		this.destStopId = destStopId;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	
}

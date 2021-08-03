package com.example.finalproject.payload.request;

import javax.validation.constraints.Size;

public class GetTripScheduleRequest {
	@Size(max = 50)
	private String tripDate;

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}
	
}

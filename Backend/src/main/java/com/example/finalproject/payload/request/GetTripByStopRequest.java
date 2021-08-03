package com.example.finalproject.payload.request;


public class GetTripByStopRequest {

	private Long sourceStopId;
	
	private Long destStopId;

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
	
}

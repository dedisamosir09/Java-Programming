package com.example.finalproject.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateBusRequest {
	@NotBlank
	@Size(max = 50)
	private String code;
	
	private int capacity;
	
	@NotBlank
	@Size(max = 50)
	private String make;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

}

package com.example.finalproject.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateAgencyRequest {    
	
	
	@NotBlank
	@Size(max = 50)
	private String code;
	
	@NotBlank
	@Size(max = 50)
	private String name;
	
	@NotBlank
	@Size(max = 50)
	private String details;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
	
}

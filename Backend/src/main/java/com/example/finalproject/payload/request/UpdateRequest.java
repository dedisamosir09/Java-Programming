package com.example.finalproject.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateRequest {
    
	@NotBlank
	@Size(max = 50)
	private String firstName;
	
	@NotBlank
	@Size(max = 50)
	private String lastName;
	
	@NotBlank
	@Size(max = 50)
	private String mobileNumber;
    
  
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}

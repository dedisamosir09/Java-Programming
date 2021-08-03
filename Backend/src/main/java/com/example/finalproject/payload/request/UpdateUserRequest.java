/**
 * 
 */
package com.example.finalproject.payload.request;

import javax.validation.constraints.Size;

/**
 * @author akbar alzaini
 *
 */
public class UpdateUserRequest {
    @Size(min = 3, max = 20)
    private String firstName;
    

    @Size(min = 3, max = 20)
    private String lastName;
    

    @Size(min = 3, max = 20)
    private String mobileNumber;



	public UpdateUserRequest(String firstName,String lastName, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}


	public UpdateUserRequest() {
	}

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

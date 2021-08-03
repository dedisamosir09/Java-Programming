package com.example.finalproject.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {

    @Size(min = 3, max = 20)
    private String username;
    

    @Size(min = 3, max = 20)
    private String firstName;
    

    @Size(min = 3, max = 20)
    private String lastName;
    

    @Size(min = 3, max = 20)
    private String mobileNumber;
 

    private Set<String> role;
    

    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
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


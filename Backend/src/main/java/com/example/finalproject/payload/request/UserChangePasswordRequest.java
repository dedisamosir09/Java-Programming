/**
 * 
 */
package com.example.finalproject.payload.request;
import javax.validation.constraints.Size;

/**
 * @author akbar alzaini
 *
 */
public class UserChangePasswordRequest {

    @Size(min = 6, max = 40)
    private String password;
    
 

	public UserChangePasswordRequest() {
	}

	public UserChangePasswordRequest(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}

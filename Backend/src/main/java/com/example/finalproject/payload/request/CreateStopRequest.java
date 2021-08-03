/**
 * 
 */
package com.example.finalproject.payload.request;

/**
 * @author akbar alzaini
 *
 */
public class CreateStopRequest {

	private String code;
	
	private String name;
	
	private String detail;

	public CreateStopRequest(String code, String name, String detail) {
		this.code = code;
		this.name = name;
		this.detail = detail;
	}

	public CreateStopRequest() {
	}

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}

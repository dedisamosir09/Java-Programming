/**
 * 
 */
package com.example.finalproject.models;

import javax.persistence.*;


/**
 * @author akbar alzaini
 *
 */
@Entity
@Table(name = "stop")
public class Stop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String code;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 20)
	private String detail;

	public Stop(String code, String name, String detail) {
		super();
		this.code = code;
		this.name = name;
		this.detail = detail;
	}

	
	public Stop() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

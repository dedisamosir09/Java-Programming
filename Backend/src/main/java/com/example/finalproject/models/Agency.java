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
@Table(name = "agency")
public class Agency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String code;
	
	@Column(length = 100)
	private String name;

	@Column(length = 200)
	private String details;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User owner;

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	

	public Agency() {
	}



	public Agency(String code, String name, String details, User owner) {
		super();
		this.code = code;
		this.name = name;
		this.details = details;
		this.owner = owner;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}

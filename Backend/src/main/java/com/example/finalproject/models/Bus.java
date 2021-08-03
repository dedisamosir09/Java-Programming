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
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String code;
	
	@Column(length = 20)
	private Integer capacity;
	
	@Column(length = 20)
	private String make;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "agency_id",referencedColumnName = "id")
	private Agency agency;

	public Bus(String code, Integer capacity, String make, Agency agency) {
		super();
		this.code = code;
		this.capacity = capacity;
		this.make = make;
		this.agency = agency;
	}
	
	
	public Bus() {
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
}
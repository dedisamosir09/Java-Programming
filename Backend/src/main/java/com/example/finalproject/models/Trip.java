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
@Table(name = "trip")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private Integer fare;
	
	@Column(length = 20)
	private String journeyTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "source_stop_id",referencedColumnName = "id")
	private Stop sourceStop;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dest_stop_id",referencedColumnName = "id")
	private Stop destStop;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bus_id",referencedColumnName = "id")
	private Bus bus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "agency_id",referencedColumnName = "id")
	private Agency agency;

	public Trip(Integer fare, String journeyTime, Stop sourceStop, Stop destStop, Bus bus, Agency agency) {
		super();
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.sourceStop = sourceStop;
		this.destStop = destStop;
		this.bus = bus;
		this.agency = agency;
	}
	
		

	public Trip() {
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public String getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}

	public Stop getSourceStop() {
		return sourceStop;
	}

	public void setSourceStop(Stop sourceStop) {
		this.sourceStop = sourceStop;
	}

	public Stop getDestStop() {
		return destStop;
	}

	public void setDestStop(Stop destStop) {
		this.destStop = destStop;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	
}

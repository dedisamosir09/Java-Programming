/**
 * 
 */
package com.example.finalproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.models.Trip;
import com.example.finalproject.models.TripSchedule;
import com.example.finalproject.payload.request.TripScheduleRequest;
import com.example.finalproject.repository.TripRepository;
import com.example.finalproject.repository.TripScheduleRepository;

/**
 * @author akbar alzaini
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/tripschedule")
public class TripScheduleController {
	@Autowired
	TripScheduleRepository tripScheduleRepository;
	
	@Autowired
	TripRepository tripRepository;
	
	@GetMapping("/")
	public List<TripSchedule> getTripSchedule() {
		return tripScheduleRepository.findAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addTripSchedule(@Valid @RequestBody TripScheduleRequest tripScheduleRequest) {
		Trip trip = tripRepository.getOne(tripScheduleRequest.getTrip_id());
		
		TripSchedule tripSchedule = new TripSchedule(tripScheduleRequest.getTripDate(),tripScheduleRequest.getAvailableSeats(),trip);
		
		tripScheduleRepository.save(tripSchedule);
		
		return ResponseEntity.ok(tripScheduleRequest);
	}
}

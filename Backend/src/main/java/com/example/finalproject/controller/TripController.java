/**
 * 
 */
package com.example.finalproject.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.models.Agency;
import com.example.finalproject.models.Bus;
import com.example.finalproject.models.Stop;
import com.example.finalproject.models.Trip;
import com.example.finalproject.models.User;
import com.example.finalproject.repository.AgencyRepository;
import com.example.finalproject.repository.BusRepository;
import com.example.finalproject.repository.StopRepository;
import com.example.finalproject.repository.TripRepository;
import com.example.finalproject.repository.UserRepository;
import com.example.finalproject.security.services.UserDetailsImpl;
import com.example.finalproject.payload.request.CreateTripRequest;
import com.example.finalproject.payload.response.MessageResponse;


/**
 * @author akbar alzaini
 * TODO: Buat put, getOne, delete
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/api/v1/trip")
public class TripController {
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	AgencyRepository agencyRepository;
	
	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StopRepository stopRepository;
	
	@PostMapping("/")
	public ResponseEntity<?> createTrip(@Valid @RequestBody CreateTripRequest createTripRequest) {
		
		UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Optional<User> u = userRepository.findByUsername(username);
		Agency agency = agencyRepository.findByOwner(u.get());
		
		Stop sourceStop = stopRepository.findById(createTripRequest.getSourceStopId()).get();
		Stop destStop = stopRepository.findById(createTripRequest.getDestStopId()).get();
		Bus bus = busRepository.findById(createTripRequest.getBusId()).get();
		
		Trip trip = new Trip(createTripRequest.getFare(), createTripRequest.getJourneyTime(),sourceStop, destStop, bus, agency);
		
		tripRepository.save(trip);

		return ResponseEntity.ok(new MessageResponse("Trip created successfully!"));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllTripsByAgency(){
		try {
			UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			Optional<User> u = userRepository.findByUsername(username);
			Agency agency = agencyRepository.findByOwner(u.get());
			
			List<Trip> trips = tripRepository.findByAgency(agency);
			
			return ResponseEntity.ok(trips);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.ok("tidak ada data");
		}
	}
	
	

}

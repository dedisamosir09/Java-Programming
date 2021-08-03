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
import com.example.finalproject.models.User;
import com.example.finalproject.payload.request.CreateBusRequest;
import com.example.finalproject.payload.response.MessageResponse;
import com.example.finalproject.repository.AgencyRepository;
import com.example.finalproject.repository.BusRepository;
import com.example.finalproject.repository.UserRepository;
import com.example.finalproject.security.services.UserDetailsImpl;

/**
 * @author akbar alzaini
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AgencyRepository agencyRepository;
	
	@PostMapping("/")
	public ResponseEntity<?> createBus(@Valid @RequestBody CreateBusRequest createBusRequest) {
		UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Optional<User> u = userRepository.findByUsername(username);
		
		Agency agency = agencyRepository.findByOwner(u.get());
		Bus bus = new Bus(createBusRequest.getCode(),createBusRequest.getCapacity(),createBusRequest.getMake(),agency);
		
		busRepository.save(bus);

		return ResponseEntity.ok(new MessageResponse("Bus created successfully!"));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllBusByAgency(){
		UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Optional<User> u = userRepository.findByUsername(username);
		
		Agency agency = agencyRepository.findByOwner(u.get());
		
		List<Bus> buses = busRepository.findByAgency(agency);
		
		return ResponseEntity.ok(buses);
	}
	
	
}

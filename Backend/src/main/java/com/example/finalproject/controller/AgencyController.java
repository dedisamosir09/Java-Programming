/**
 * 
 */
package com.example.finalproject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.models.Agency;
import com.example.finalproject.models.User;
import com.example.finalproject.payload.request.CreateAgencyRequest;
import com.example.finalproject.payload.response.MessageResponse;
import com.example.finalproject.repository.AgencyRepository;
import com.example.finalproject.repository.UserRepository;
import com.example.finalproject.security.services.UserDetailsImpl;

/**
 * @author akbar alzaini
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.PUT,RequestMethod.POST,RequestMethod.GET})
@RestController
@RequestMapping("/api/v1/agency")
public class AgencyController {
	
	@Autowired
	AgencyRepository agencyRepository;
	
	@Autowired
	UserRepository userRepository;

	
	@PostMapping("/")
	public ResponseEntity<?> createAgency(@Valid @RequestBody CreateAgencyRequest createAgencyRequest) {
		
		UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long id = userDetails.getId();
		User user = userRepository.getOne(id);
		Agency agency = new Agency(createAgencyRequest.getCode(), createAgencyRequest.getName(), createAgencyRequest.getDetails(),user);

		agencyRepository.save(agency);

		return ResponseEntity.ok(new MessageResponse("Agency created successfully!"));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAgency(){
		UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Optional<User> u = userRepository.findByUsername(username);
		
		Agency agency = agencyRepository.findByOwner(u.get());
		
//		System.out.println("stvsus"+agency.getName());
		return ResponseEntity.ok(agency);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateAgency(@RequestBody CreateAgencyRequest createAgencyRequest){
		
			UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			Optional<User> u = userRepository.findByUsername(username);
			
			Agency a = agencyRepository.findByOwner(u.get());
			a.setDetails(createAgencyRequest.getDetails());
			a.setName(createAgencyRequest.getName());
			Agency update = agencyRepository.save(a);
			
			return ResponseEntity.ok(update);

	}
}

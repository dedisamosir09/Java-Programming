/**
 * 
 */
package com.example.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.models.User;
import com.example.finalproject.payload.request.UpdateUserRequest;
import com.example.finalproject.payload.request.UserChangePasswordRequest;
import com.example.finalproject.repository.UserRepository;
import com.example.finalproject.security.services.UserDetailsImpl;

/**
 * @author akbar alzaini
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.PUT,RequestMethod.POST,RequestMethod.GET})
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/")
	public ResponseEntity<?> getUser(){
		UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User u = userRepository.findByUsername(username).get();
		
		return ResponseEntity.ok(u);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateUser(@Validated @RequestBody UpdateUserRequest updateUserRequest){
		UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User u = userRepository.findByUsername(username).get();
		u.setFirstName(updateUserRequest.getFirstName());
		u.setLastName(updateUserRequest.getLastName());
		u.setMobileNumber(updateUserRequest.getMobileNumber());
		
		User usr = userRepository.save(u);
		
		return ResponseEntity.ok(usr);
	}
	
	@PutMapping("/password")
	public ResponseEntity<?> updatePassword(@Validated @RequestBody UserChangePasswordRequest updateUserRequest){
		UserDetailsImpl userDetails =  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User u = userRepository.findByUsername(username).get();
		u.setPassword(encoder.encode(updateUserRequest.getPassword()));
		
//		userRepository.save(u);
		User usr = userRepository.save(u);
		return ResponseEntity.ok(usr);
	}
}

/**
 * 
 */
package com.example.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.models.Ticket;
import com.example.finalproject.repository.TicketRepository;

/**
 * @author akbar alzaini
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
	@Autowired
	TicketRepository ticketRepository;
	
	@GetMapping("/")
	public List<Ticket> getTicket() {
		return ticketRepository.findAll();
	}
}

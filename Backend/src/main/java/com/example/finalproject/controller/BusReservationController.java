/**
 * 
 */
package com.example.finalproject.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.models.Stop;
import com.example.finalproject.models.Ticket;
import com.example.finalproject.models.Trip;
import com.example.finalproject.models.TripSchedule;
import com.example.finalproject.models.User;
import com.example.finalproject.payload.request.CreateTicketRequest;
import com.example.finalproject.payload.request.GetTripByStopRequest;
import com.example.finalproject.payload.request.GetTripScheduleRequest;
import com.example.finalproject.payload.response.MessageResponse;
import com.example.finalproject.repository.AgencyRepository;
import com.example.finalproject.repository.BusRepository;
import com.example.finalproject.repository.StopRepository;
import com.example.finalproject.repository.TicketRepository;
import com.example.finalproject.repository.TripRepository;
import com.example.finalproject.repository.TripScheduleRepository;
import com.example.finalproject.repository.UserRepository;

/**
 * @author akbar alzaini
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/reservation")
public class BusReservationController {
	
	@Autowired
	AgencyRepository agencyRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	StopRepository stopRepository;
	
	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	TripScheduleRepository tripScheduleRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	
	@GetMapping("/stops")
	public ResponseEntity<?> getStop() {
		List<Stop> stops = stopRepository.findAll();

		return ResponseEntity.ok(stops);
	}
	
	@PostMapping("/tripsbystops")
	public ResponseEntity<?> getTripByStop(@Valid @RequestBody GetTripByStopRequest getTripByStopRequest) {
		Stop sourceStop = stopRepository.getOne(getTripByStopRequest.getSourceStopId());
		Stop destStop = stopRepository.getOne(getTripByStopRequest.getDestStopId());
		List<Trip> trips = tripRepository.findAllBySourceStopAndDestStop(sourceStop, destStop);

		return ResponseEntity.ok(trips);
	}
	
	@PostMapping("/tripschedules")
	public ResponseEntity<?> getTripSchedule(@Valid @RequestBody GetTripScheduleRequest getTripScheduleRequest) {
		List<TripSchedule> tripSchedules = tripScheduleRepository.findAllByTripDate(getTripScheduleRequest.getTripDate());
			
		return ResponseEntity.ok(tripSchedules);
	}
	
	
	@PostMapping("/bookticket")
	public ResponseEntity<?> createTicket(@Valid @RequestBody CreateTicketRequest createTicketRequest) {
		User passenger = userRepository.findById(createTicketRequest.getPassengerId()).get();
		TripSchedule tripSchedule = tripScheduleRepository.findById(createTicketRequest.getTripScheduleId()).get();
		Ticket ticket = new Ticket(createTicketRequest.getSeatNumber(), createTicketRequest.getCancellable(), createTicketRequest.getJourneyDate(), passenger, tripSchedule);
		ticketRepository.save(ticket);
		
		Set<Ticket> ticketSold = tripSchedule.getTicketsSold();
		ticketSold.add(ticket);
		
		tripSchedule.setTicketsSold(ticketSold);
		tripScheduleRepository.save(tripSchedule);

		return ResponseEntity.ok(new MessageResponse("Ticket created successfully!"));
	}
	
}

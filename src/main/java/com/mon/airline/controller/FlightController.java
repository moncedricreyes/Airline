package com.mon.airline.controller;

import java.text.ParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mon.airline.model.Flight;
import com.mon.airline.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@GetMapping("/flights")
	public ResponseEntity<?> retrieveAllTodayFlights() {
		
		return ResponseEntity.ok(flightService.retrieveAllTodayFlights());
		 
	}
	
	@GetMapping("/flight/{airlineCode}")
	public ResponseEntity<?> retrieveFlightByAirlineCode(@PathVariable String airlineCode) {

		return flightService.retrieveFlightByAirlineCode(airlineCode);
		 
	}
	
	@PostMapping("/flight")
	public ResponseEntity<?> newFlight(@Validated @RequestBody Flight flight) throws ParseException {
		
		return flightService.newFlight(flight);
	}
}

package com.mon.airline.service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mon.airline.model.Flight;
import com.mon.airline.model.Message;

@Component
public class FlightService {

	private static List<Flight> flights = new ArrayList<>();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	static {

		Flight f1 = new Flight("QF400", "MEL", "SYD", LocalDateTime.parse("2020-06-10 10:25:23", formatter),
				LocalDateTime.parse("2020-06-10 10:25:23", formatter));

		Flight f2 = new Flight("EK500", "MEL", "SYD", LocalDateTime.parse("2020-06-10 08:24:23", formatter),
				LocalDateTime.parse("2020-06-10 10:00:23", formatter));
		
		Flight f3 = new Flight("EK300", "MEL", "SYD", LocalDateTime.parse("2020-05-10 01:24:23", formatter),
				LocalDateTime.parse("2020-06-10 03:00:23", formatter));

		
		flights.add(f1);
		flights.add(f2);
		flights.add(f3);

	}

	public List<Flight> retrieveAllTodayFlights() {
		return flights;
	}

	public Flight retrieveFlight(String flightNumber) {
		for (Flight flight : flights) {
			if (flight.getFlightNumber().equals(flightNumber)) {
				return flight;
			}
		}

		return null;
	}

	public ResponseEntity<?> retrieveFlightByAirlineCode(String airlineCode) {

		List<Flight> flightList = new ArrayList<>();
		
		for (Flight flight : flights) {
			String fKey = flight.getFlightNumber().substring(0, 2);
			if (fKey.equalsIgnoreCase(airlineCode)) {
				flightList.add(flight);
			}
		}

		if (flightList.size() > 0) {
			return ResponseEntity.ok(flightList);
		}
		return ResponseEntity.badRequest().body(new Message("No record found."));
	}
	
	public ResponseEntity<?> newFlight(Flight flight) throws ParseException {
		
		Flight flightSearch = retrieveFlight(flight.getFlightNumber());

		if (flightSearch == null) {
			
			flights.add(flight);
			return ResponseEntity.ok(new Message("Flight Record Added."));
		}
		return ResponseEntity.badRequest().body(new Message("Flight number already exist."));

	}

}

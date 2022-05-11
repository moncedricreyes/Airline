package com.mon.airline;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mon.airline.model.Flight;
import com.mon.airline.service.FlightService;

@SpringBootTest
class AirlineApplicationTests {

	@Autowired
	private FlightService flightService;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Test
	public void testNewFlight() throws ParseException {
		
		Flight f = new Flight();
		f.setFlightNumber("QF1000");
		f.setDeparturePort("MEL");
		f.setArrivalPort("SYD");
		f.setDepartureTime(LocalDateTime.parse("2020-06-10 10:25:23", formatter));
		f.setDepartureTime(LocalDateTime.parse("2020-06-10 12:22:23", formatter));
		flightService.newFlight(f);
		assertNotNull(flightService.retrieveFlight("QF1000"));
	}
	
	@Test
	public void testNewFlightBadRequest() throws ParseException {
		Flight f = new Flight();
		f.setFlightNumber("EK500");
		f.setDeparturePort("MEL");
		f.setArrivalPort("SYD");
		f.setDepartureTime(LocalDateTime.parse("2020-06-10 10:25:23", formatter));
		f.setDepartureTime(LocalDateTime.parse("2020-06-10 12:22:23", formatter));
		
		ResponseEntity<?> response = flightService.newFlight(f);
		
		assertEquals(response.getStatusCode(),HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void testFlightRecords() throws ParseException { 
		
		assertNotNull(flightService.retrieveAllTodayFlights());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFlightByAirlineCode() throws ParseException {
		String flightKey = "EK";
		ResponseEntity<?> response = flightService.retrieveFlightByAirlineCode(flightKey);
		List<Flight> flightList = (List<Flight>) response.getBody();
		assertNotNull(flightList);
	}
	
	@Test
	public void testFlightByAirlineCodeBadRequest() throws ParseException {
		String flightKey = "ZZ";
		ResponseEntity<?> response = flightService.retrieveFlightByAirlineCode(flightKey);
		assertEquals(response.getStatusCode(),HttpStatus.BAD_REQUEST);
	}
	
}

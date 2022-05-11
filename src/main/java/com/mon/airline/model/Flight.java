package com.mon.airline.model;

import java.time.LocalDateTime;

public class Flight {
	private String flightNumber;
	private String departurePort;
	private String arrivalPort;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	public String getArrivalPort() {
		return arrivalPort;
	}

	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Flight(String flightNumber, String departurePort, String arrivalPort, LocalDateTime departureTime,
			LocalDateTime arrivalTime) {
		super();
		this.flightNumber = flightNumber;
		this.departurePort = departurePort;
		this.arrivalPort = arrivalPort;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

}

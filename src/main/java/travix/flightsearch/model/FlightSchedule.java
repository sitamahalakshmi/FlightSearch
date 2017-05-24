package main.java.travix.flightsearch.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FlightSchedule {

	private IATACode departureAirportCode;

	private Date departureDate;

	private IATACode arrivalAirportCode;

	private Date arrivalDate;

	public IATACode getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(IATACode departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public IATACode getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(IATACode arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	private Supplier supplier;

	private String airline;

	private double fare;

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}

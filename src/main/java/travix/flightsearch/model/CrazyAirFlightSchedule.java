package main.java.travix.flightsearch.model;

import org.springframework.stereotype.Component;

@Component
public class CrazyAirFlightSchedule extends FlightSchedule {

	private CabinClass cabinclass;

	private String dateFormat;

	public CabinClass getCabinclass() {
		return cabinclass;
	}

	public void setCabinclass(CabinClass cabinclass) {
		this.cabinclass = cabinclass;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

}

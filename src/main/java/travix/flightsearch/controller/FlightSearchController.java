package main.java.travix.flightsearch.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.travix.flightsearch.exception.SeatsNotAvailableException;
import main.java.travix.flightsearch.model.FlightSchedule;
import main.java.travix.flightsearch.service.FlightSearchService;

@RestController
public class FlightSearchController {

	@Autowired
	private FlightSearchService flightSearchService;

	@RequestMapping(path = "/flightsearch", method = RequestMethod.GET, produces = "application/json")
	public List<FlightSchedule> getFlights(@RequestParam("origin") String origin,
			@RequestParam("destination") String destination, @RequestParam("departureDate") Date departureDate,
			@RequestParam("returnDate") Date returnDate, @RequestParam("numberOfPassengers") int numberOfPassengers) {
		List<FlightSchedule> flightList = new ArrayList();
		flightList = flightSearchService.searchFlights(origin, destination, departureDate, returnDate,
				numberOfPassengers);

		if (flightList.isEmpty()) {
			throw new SeatsNotAvailableException("Seats are not available for the given departure date " + departureDate
					+ " and return date" + returnDate + " in between " + origin + " and " + destination);
		}
		return flightList;

	}

}

package main.java.travix.flightsearch.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import main.java.travix.flightsearch.exception.FlightSearchException;
import main.java.travix.flightsearch.model.CrazyAirFlightSchedule;
import main.java.travix.flightsearch.model.DateFactory;
import main.java.travix.flightsearch.model.FlightSchedule;
import main.java.travix.flightsearch.model.ToughJetFlightSchedule;
import main.java.travix.flightsearch.utils.DateUtils;

@Service
public class FlightSearchService {

	@Autowired
	private RestTemplate restTemplate;

	public List<FlightSchedule> searchFlights(String origin, String destination, Date departureDate, Date returnDate,
			int numberOfPassengers) {
		List<FlightSchedule> flightsList = new ArrayList();
		flightsList.addAll(getCrazyAirFlights(origin, destination, departureDate, returnDate, numberOfPassengers));
		flightsList.addAll(getToughJetFlights(origin, destination, departureDate, returnDate, numberOfPassengers));

		return flightsList;
	}

	private List<FlightSchedule> getToughJetFlights(String origin, String destination, Date departureDate,
			Date returnDate, int numberOfPassengers) {
		Integer departureDay = DateUtils.getDay(departureDate);
		Integer departureMonth = DateUtils.getMonth(departureDate);
		Integer departureYear = DateUtils.getYear(departureDate);

		Integer returnDay = DateUtils.getDay(returnDate);
		Integer returnMonth = DateUtils.getMonth(returnDate);
		Integer returnYear = DateUtils.getYear(departureDate);

		ResponseEntity<ToughJetFlightSchedule[]> responseEntity = restTemplate.getForEntity(
				"/flightsearch/toughjet?from=" + origin + "&to=" + destination + "&departureDay=" + departureDay
						+ "&departureMonth=" + departureMonth + "&departureYear=" + departureYear + "&returnDay="
						+ returnDay + "&returnMonth=" + returnMonth + "&returnYear=" + returnYear,
				main.java.travix.flightsearch.model.ToughJetFlightSchedule[].class);
		return Arrays.asList(responseEntity.getBody());
	}

	private List<FlightSchedule> getCrazyAirFlights(String origin, String destination, Date departureDate,
			Date returnDate, int numberOfPassengers) {

		Date returnDateInSupplierFormat;
		ResponseEntity<CrazyAirFlightSchedule[]> responseEntity;
		try {
			returnDateInSupplierFormat = DateUtils.getDate(returnDate,
					DateFactory.getDateFormat(main.java.travix.flightsearch.model.Supplier.CrazyAir.toString()));

			Date departureDateInSupplierFormat = DateUtils.getDate(departureDate,
					DateFactory.getDateFormat(main.java.travix.flightsearch.model.Supplier.CrazyAir.toString()));

			responseEntity = restTemplate
					.getForEntity(
							"/flightsearch/crazyair?origin=" + origin + "&destination=" + destination
									+ "&departureDate=" + departureDateInSupplierFormat + "&returnDate="
									+ returnDateInSupplierFormat + "&numberOfPassengers=" + numberOfPassengers,
							CrazyAirFlightSchedule[].class);
		} catch (ParseException e) {
			throw new FlightSearchException(e.getMessage(), e);
		}
		return Arrays.asList(responseEntity.getBody());
	}

}

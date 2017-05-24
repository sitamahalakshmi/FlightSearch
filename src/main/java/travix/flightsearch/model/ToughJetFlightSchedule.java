package main.java.travix.flightsearch.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import main.java.travix.flightsearch.utils.DateUtils;

@Component
public class ToughJetFlightSchedule extends FlightSchedule {

	private double basePrice;
	private double tax;
	private int departureDay;
	private int departureMonth;
	private int departureYear;
	private int returnDay;
	private int returnMonth;
	private int returnYear;
	private double discount;

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public int getDepartureDay() {
		return departureDay;
	}

	public void setDepartureDay(int departureDay) {
		this.departureDay = departureDay;
	}

	public int getDepartureMonth() {
		return departureMonth;
	}

	public void setDepartureMonth(int departureMonth) {
		this.departureMonth = departureMonth;
	}

	public int getDepartureYear() {
		return departureYear;
	}

	public void setDepartureYear(int departureYear) {
		this.departureYear = departureYear;
	}

	public int getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(int returnDay) {
		this.returnDay = returnDay;
	}

	public int getReturnMonth() {
		return returnMonth;
	}

	public void setReturnMonth(int returnMonth) {
		this.returnMonth = returnMonth;
	}

	public int getReturnYear() {
		return returnYear;
	}

	public void setReturnYear(int returnYear) {
		this.returnYear = returnYear;
	}

	// assume discount is on base price
	@Override
	public double getFare() {
		return basePrice + tax - (discount * basePrice / 100);

	}

	@Override
	public Date getArrivalDate() {
		return DateUtils.getDate(returnDay, returnMonth, returnYear);

	}

	@Override
	public Date getDepartureDate() {
		return DateUtils.getDate(departureDay, departureMonth, departureYear);

	}
}

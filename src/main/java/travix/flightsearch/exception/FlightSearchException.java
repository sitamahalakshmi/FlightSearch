package main.java.travix.flightsearch.exception;

public class FlightSearchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 802530537803365306L;

	public FlightSearchException() {
		super();
	}

	public FlightSearchException(String s) {
		super(s);
	}

	public FlightSearchException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public FlightSearchException(Throwable throwable) {
		super(throwable);
	}
}

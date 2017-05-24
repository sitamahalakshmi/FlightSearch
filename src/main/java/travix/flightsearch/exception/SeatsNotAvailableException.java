package main.java.travix.flightsearch.exception;

public class SeatsNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1983161687287179433L;

	public SeatsNotAvailableException() {
		super();
	}

	public SeatsNotAvailableException(String s) {
		super(s);
	}

	public SeatsNotAvailableException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public SeatsNotAvailableException(Throwable throwable) {
		super(throwable);
	}
}

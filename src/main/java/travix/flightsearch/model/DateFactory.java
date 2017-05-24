package main.java.travix.flightsearch.model;

public class DateFactory {

	public static String getDateFormat(String supplier) {
		String supplierName = supplier;
		String dateFormat;
		switch (supplierName) {
		case "CrazyAir":
			dateFormat = "mm-dd-yyyy HH:MM:ss";
			break;
		case "ToughJet":
			dateFormat = "mm-dd-yyyy";
			break;

		case "All":
			dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ";
			break;

		default:
			dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ";

		}
		return dateFormat;
	}

}

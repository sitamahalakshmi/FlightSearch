package main.java.travix.flightsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FlightSearchConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

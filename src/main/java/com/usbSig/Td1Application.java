package com.usbSig;

import com.usbSig.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Td1Application  implements CommandLineRunner {
	@Autowired
private ICinemaInitService iCinemaInitService;
	public static void main(String[] args) {
		SpringApplication.run(Td1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		iCinemaInitService.initVilles();
		iCinemaInitService.initCinamas();
		iCinemaInitService.initSalle();
		iCinemaInitService.initPlaces();
		iCinemaInitService.initSeances();
		iCinemaInitService.initCategories();
		iCinemaInitService.films();
		iCinemaInitService.initTicket();
	}
}

package com.scrumtrek.simplestore;

import java.util.logging.Level;
import java.util.logging.Logger;

class MainClass {

	private MainClass(){}

	 static void Main() {
		Movie cinderella = new Movie("Cinderella", PriceCodes.Childrens);
		Movie starWars = new Movie("Star Wars", PriceCodes.Regular);
		Movie gladiator = new Movie("Gladiator", PriceCodes.NewRelease);

		Customer mickeyMouse = new Customer("Mickey Mouse");

		mickeyMouse.addRental(new Rental(cinderella, 5));
		mickeyMouse.addRental(new Rental(starWars, 5));
		mickeyMouse.addRental(new Rental(gladiator, 5));

		String statement = mickeyMouse.buildStatement();

		 Logger logger = Logger.getLogger("Custom.log");
		 logger.log(Level.INFO, statement);
		 
		 System.out.println(statement);
	}
}


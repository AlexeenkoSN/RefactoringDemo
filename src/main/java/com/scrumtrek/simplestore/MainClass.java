package com.scrumtrek.simplestore;

class MainClass {
	 static void Main(String[] args) {
		Movie cinderella = new Movie("Cinderella", PriceCodes.Childrens);
		Movie starWars = new Movie("Star Wars", PriceCodes.Regular);
		Movie gladiator = new Movie("Gladiator", PriceCodes.NewRelease);

		Customer mickeyMouse = new Customer("Mickey Mouse");

		mickeyMouse.addRental(new Rental(cinderella, 5));
		mickeyMouse.addRental(new Rental(starWars, 5));
		mickeyMouse.addRental(new Rental(gladiator, 5));

		String statement = mickeyMouse.buildStatement();

		System.out.println(statement);
	}
}


package com.scrumtrek.simplestore;

class MainClass {

    private MainClass() {
    }

    static void main() {
        Movie cinderella = new Movie("Cinderella", PriceCodes.CHILDRENS);
        Movie starWars = new Movie("Star Wars", PriceCodes.REGULAR);
        Movie gladiator = new Movie("Gladiator", PriceCodes.NEW_RELEASE);

        Customer mickeyMouse = new Customer("Mickey Mouse");

        mickeyMouse.addRental(new Rental(cinderella, 5));
        mickeyMouse.addRental(new Rental(starWars, 5));
        mickeyMouse.addRental(new Rental(gladiator, 5));

        String statement = mickeyMouse.buildStatement();

        System.out.println(statement);
    }
}


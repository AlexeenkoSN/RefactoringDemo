package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String buildStatement() {
        double totalPrice = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + name + "\n";

        for (Rental rental : rentals) {
            double price = calculatePrice(rental);
            totalPrice += price;
            frequentRenterPoints += calculateRenterPoints(rental);

            result += "\t" + rental.getMovie().getTitle() + "\t" + price + "\n";
        }

        result += "Amount owed is " + totalPrice + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }

    private int calculateRenterPoints(Rental rental) {
        int renterPoints = 1;
        if ((rental.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) && (rental.getDaysRented() > 1)) {
            renterPoints++;
        }

        return renterPoints;
    }

    private double calculatePrice(Rental rental) {
        switch (rental.getMovie().getPriceCode()) {
            case REGULAR:
                return calculateRegularPrice(rental);

            case NEW_RELEASE:
                return calculateNewReleasePrice(rental);

            case CHILDRENS:
                return  calculateChildrenPrice(rental);
            default:
                return 0;
        }
    }

    private double calculateChildrenPrice(Rental rental) {
        double resultPrice = 1.5;
        if (rental.getDaysRented() > 3)
        {
            resultPrice = (rental.getDaysRented() - 3) * 1.5;
        }
        return resultPrice;
    }

    private double calculateNewReleasePrice(Rental rental) {
        return rental.getDaysRented() * 3.0;
    }

    private double calculateRegularPrice(Rental rental) {
        double resultPrice = 2;
        if (rental.getDaysRented() > 2)
        {
            resultPrice += (rental.getDaysRented() - 2) * 1.5;
        }
        return resultPrice;
    }
}


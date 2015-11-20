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

    public String buildStatementString() {
        Statement statement = buildStatement();

        String result = "Rental record for " + statement.getCustomerName() + "\n";

        for (StatementLine statementLine : statement.getStatementLines()) {
            result += "\t" + statementLine.getTitle() + "\t" + statementLine.getPrice() + "\n";
        }

        result += "Amount owed is " + statement.getTotalPrice() + "\n";
        result += "You earned " + statement.getFrequentRenterPoints() + " frequent renter points.";
        return result;
    }

    private Statement buildStatement() {
        Statement statement = new Statement(name);

        for (Rental rental : rentals) {

            statement.addLine(new StatementLine(
                    rental.getMovie().getTitle(),
                    calculatePrice(rental),
                    calculateRenterPoints(rental)));
        }

        return statement;
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


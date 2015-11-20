package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    private final StatementBuilder statementBuilder;

    public Customer(String name) {
        this.name = name;
        statementBuilder = new StatementBuilder(this);
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String buildStatementString() {
        Statement statement = statementBuilder.buildStatement();

        String result = "Rental record for " + statement.getCustomerName() + "\n";

        for (StatementLine statementLine : statement.getStatementLines()) {
            result += "\t" + statementLine.getTitle() + "\t" + statementLine.getPrice() + "\n";
        }

        result += "Amount owed is " + statement.getTotalPrice() + "\n";
        result += "You earned " + statement.getFrequentRenterPoints() + " frequent renter points.";
        return result;
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}


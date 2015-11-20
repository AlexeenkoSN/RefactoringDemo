package com.scrumtrek.simplestore;

public class StatementBuilder {
    private Customer customer;

    public StatementBuilder(Customer customer) {
        this.customer = customer;
    }

    public Statement buildStatement() {
        Statement statement = new Statement(customer.getName());

        for (Rental rental : customer.getRentals()) {

            statement.addLine(new StatementLine(
                    rental.getMovie().getTitle(),
                    calculatePrice(rental),
                    calculateRenterPoints(rental)));
        }

        return statement;
    }

    private double calculatePrice(Rental rental) {
        switch (rental.getMovie().getPriceCode()) {
            case REGULAR:
                return calculateRegularPrice(rental);

            case NEW_RELEASE:
                return calculateNewReleasePrice(rental);

            case CHILDRENS:
                return calculateChildrenPrice(rental);
            default:
                return 0;
        }
    }

    private double calculateChildrenPrice(Rental rental) {
        double resultPrice = 1.5;
        if (rental.getDaysRented() > 3) {
            resultPrice = (rental.getDaysRented() - 3) * 1.5;
        }
        return resultPrice;
    }

    private double calculateNewReleasePrice(Rental rental) {
        return rental.getDaysRented() * 3.0;
    }

    private double calculateRegularPrice(Rental rental) {
        double resultPrice = 2;
        if (rental.getDaysRented() > 2) {
            resultPrice += (rental.getDaysRented() - 2) * 1.5;
        }
        return resultPrice;
    }

    private int calculateRenterPoints(Rental rental) {
        int renterPoints = 1;
        if ((rental.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) && (rental.getDaysRented() > 1)) {
            renterPoints++;
        }

        return renterPoints;
    }
}

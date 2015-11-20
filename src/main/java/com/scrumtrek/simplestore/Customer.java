package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	final private String m_Name;
	final private List<Rental> m_Rentals = new ArrayList<>();

	public Customer(String name) {
		m_Name = name;
	}

	public void addRental(Rental rental){
		m_Rentals.add(rental);
	}

	public String buildStatement()
	{
		double totalPrice = 0;
		int frequentRenterPoints = 0;
				
		String result = "Rental record for " + m_Name + "\n";
		
		for(Rental rental: m_Rentals) {
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
		if ((rental.getMovie().getPriceCode() == PriceCodes.NewRelease) && (rental.getDaysRented() > 1))
		{
			renterPoints++;
		}

		return renterPoints;
	}

	private double calculatePrice(Rental rental) {
		switch(rental.getMovie().getPriceCode()) {
            case Regular:
                return calculateRegularPrice(rental);

            case NewRelease:
				return calculateNewReleasePrice(rental);

            case Childrens:
                return  calculateChildrenPrice(rental);
        }

		return 0;
	}

	private double calculateChildrenPrice(Rental rental) {
		double thisAmount = 1.5;
		if (rental.getDaysRented() > 3)
        {
            thisAmount = (rental.getDaysRented() - 3) * 1.5;
        }
		return thisAmount;
	}

	private double calculateNewReleasePrice(Rental rental) {
		return rental.getDaysRented() * 3;
	}

	private double calculateRegularPrice(Rental rental) {
		double thisAmount = 2;
		if (rental.getDaysRented() > 2)
        {
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
        }
		return thisAmount;
	}
}


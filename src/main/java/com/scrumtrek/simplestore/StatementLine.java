package com.scrumtrek.simplestore;

public class StatementLine {
    private String title;
    private double price;
    private int frequentRenterPoints;

    public StatementLine(String title, double price, int frequentRenterPoints) {
        this.title = title;
        this.price = price;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}

package com.scrumtrek.simplestore;

import java.util.LinkedList;
import java.util.List;

public class Statement {
    private String customerName;
    private double totalPrice;
    private int frequentRenterPoints;
    private List<StatementLine> statementLines = new LinkedList<>();

    public Statement(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<StatementLine> getStatementLines() {
        return statementLines;
    }

    public void addLine(StatementLine line) {
        totalPrice += line.getPrice();
        frequentRenterPoints += line.getFrequentRenterPoints();
        statementLines.add(line);
    }
}


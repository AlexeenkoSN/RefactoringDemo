package com.scrumtrek.simplestore;


public class Rental {
    private final Movie movie;
    private final int daysRented;

    /* Ctor */
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    /* Get movie rented days */
    public int getDaysRented() {
        return daysRented;
    }

    /* Get initialised movie */
    public Movie getMovie() {
        return movie;
    }
}


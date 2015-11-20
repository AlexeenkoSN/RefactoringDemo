package com.scrumtrek.simplestore;

public class Movie {
    private final String title;
    private PriceCodes priceCodes;

    /* Constructor */
    public Movie(String title, PriceCodes priceCode) {
        this.title = title;
        priceCodes = priceCode;
    }

    /*  Movie Price*/
    public PriceCodes getPriceCode() {
        return priceCodes;
    }

    /* Title of the movie */
    public String getTitle() {
        return title;
    }
}


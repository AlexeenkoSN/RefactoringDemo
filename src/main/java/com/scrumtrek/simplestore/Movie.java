package com.scrumtrek.simplestore;

public class Movie {
	private final String title;
	private PriceCodes priceCodes;

	public Movie(String title, PriceCodes priceCode) {
		this.title = title;
		priceCodes = priceCode;
	}

	public PriceCodes getPriceCode()	{
		return priceCodes;
	}
	
	public String getTitle() {
		return title;
	}
}


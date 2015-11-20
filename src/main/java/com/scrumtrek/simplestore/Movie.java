package com.scrumtrek.simplestore;

public class Movie {
	final private String m_Title;
	private PriceCodes m_PriceCode;

	public Movie(String title, PriceCodes priceCode) {
		m_Title = title;
		m_PriceCode = priceCode;
	}

	public PriceCodes getPriceCode()	{
		return m_PriceCode;
	}
	
	public String getTitle() {
		return m_Title;
	}
}


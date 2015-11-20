package com.scrumtrek.simplestore;

public class Rental {
	final private Movie m_Movie;
	final private int m_DaysRented;

	public Rental(Movie movie, int daysRented) {
		m_Movie = movie;
		m_DaysRented = daysRented;
	}

	public int getDaysRented() {
		return m_DaysRented;
	}

	public Movie getMovie() {
		return m_Movie;
	}
}


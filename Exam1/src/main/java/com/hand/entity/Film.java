package com.hand.entity;

import java.sql.Date;
import java.util.Arrays;
import java.util.TreeSet;

public class Film {
	private int film_id;
	private String title;
	private String description;
	private Date release_year;
	private short language_id;
	private short original_language_id;
	private short rental_duration;
	private double rental_rate;
	private int length;
	private double replacement_cost;
	private String[] rating;
	private TreeSet<String> special_features;
	private Date last_update;
	/**
	 * @return the film_id
	 */
	public int getFilm_id() {
		return film_id;
	}
	/**
	 * @param film_id the film_id to set
	 */
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the release_year
	 */
	public Date getRelease_year() {
		return release_year;
	}
	/**
	 * @param release_year the release_year to set
	 */
	public void setRelease_year(Date release_year) {
		this.release_year = release_year;
	}
	/**
	 * @return the language_id
	 */
	public short getLanguage_id() {
		return language_id;
	}
	/**
	 * @param language_id the language_id to set
	 */
	public void setLanguage_id(short language_id) {
		this.language_id = language_id;
	}
	/**
	 * @return the original_language_id
	 */
	public short getOriginal_language_id() {
		return original_language_id;
	}
	/**
	 * @param original_language_id the original_language_id to set
	 */
	public void setOriginal_language_id(short original_language_id) {
		this.original_language_id = original_language_id;
	}
	/**
	 * @return the rental_duration
	 */
	public short getRental_duration() {
		return rental_duration;
	}
	/**
	 * @param rental_duration the rental_duration to set
	 */
	public void setRental_duration(short rental_duration) {
		this.rental_duration = rental_duration;
	}
	/**
	 * @return the rental_rate
	 */
	public double getRental_rate() {
		return rental_rate;
	}
	/**
	 * @param rental_rate the rental_rate to set
	 */
	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the replacement_cost
	 */
	public double getReplacement_cost() {
		return replacement_cost;
	}
	/**
	 * @param replacement_cost the replacement_cost to set
	 */
	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	/**
	 * @return the rating
	 */
	public String[] getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String[] rating) {
		this.rating = rating;
	}
	/**
	 * @return the special_features
	 */
	public TreeSet<String> getSpecial_features() {
		return special_features;
	}
	/**
	 * @param special_features the special_features to set
	 */
	public void setSpecial_features(TreeSet<String> special_features) {
		this.special_features = special_features;
	}
	/**
	 * @return the last_update
	 */
	public Date getLast_update() {
		return last_update;
	}
	/**
	 * @param last_update the last_update to set
	 */
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title
				+ ", description=" + description + ", release_year="
				+ release_year + ", language_id=" + language_id
				+ ", original_language_id=" + original_language_id
				+ ", rental_duration=" + rental_duration + ", rental_rate="
				+ rental_rate + ", length=" + length + ", replacement_cost="
				+ replacement_cost + ", rating=" + Arrays.toString(rating)
				+ ", special_features=" + special_features + ", last_update="
				+ last_update + "]";
	}
	
}

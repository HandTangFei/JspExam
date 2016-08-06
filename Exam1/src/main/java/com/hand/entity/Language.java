package com.hand.entity;

import java.sql.Date;

public class Language {
	private short language_id;
	private String name;
	private Date timastamp;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the timastamp
	 */
	public Date getTimastamp() {
		return timastamp;
	}
	/**
	 * @param timastamp the timastamp to set
	 */
	public void setTimastamp(Date timastamp) {
		this.timastamp = timastamp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Language [language_id=" + language_id + ", name=" + name
				+ ", timastamp=" + timastamp + "]";
	}
	
}

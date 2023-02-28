package com.AlvaroIrarrazabal.Spring.boot.model;

public class Region {

	private long id;
	private String name;
	private String abbreviation;
	
	
	public Region() {
		super();
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
	}
	public Region(String name, String abbreviation) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + "]";
	}

	/**
	 * @return the idRegion
	 */
	
	
	
	
}

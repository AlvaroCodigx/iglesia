package com.AlvaroIrarrazabal.Spring.boot.model;

public class Country {
	
	private Long id;
	private String shortName;
	private String name;
	
	
	


	public Country() {
		super();
	}


	public Country(Long id, String shortName, String name) {
		super();
		this.id = id;
		this.shortName = shortName;
		this.name = name;
	}


	public Country(String shortName, String name) {
		super();
		this.shortName = shortName;
		this.name = name;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}


	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param nombre_pais the nombre_pais to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Country [id=" + id + ", shortName=" + shortName + ", name=" + name + "]";
	}


	
	

	
	
	
	
	

}

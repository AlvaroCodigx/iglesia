package com.AlvaroIrarrazabal.Spring.boot.model;

public class Commune {

	private long id;
	private String name;


	public Commune() {
		//TODO Auto-generated constructor stub
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
	 * @return the nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Comuna [id=" + id + ", name=" + name + "]";
	}

	


}

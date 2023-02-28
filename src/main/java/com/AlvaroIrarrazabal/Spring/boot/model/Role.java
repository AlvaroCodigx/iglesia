package com.AlvaroIrarrazabal.Spring.boot.model;

public class Role {
	
	
	private Long id;
	private String name;
	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role(String name) {
		super();
		this.name = name;
	}
	public Role() {
		//TODO Auto-generated constructor stub
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}

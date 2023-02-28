package com.AlvaroIrarrazabal.Spring.boot.model;

import java.util.Date;

public class Person {

	private long id;
	private String name;
	private String lastName;
	private String lastName2;
	private String email;
	private String phone;
	private Date birthDate;
	private Country country;
	private Region region;
	private Commune commune;
	private Role role;
	private long supervisorId;
	private String nameSuper;
	private String lastnameSuper;
	private String lastName2Super;
	
	
	public Person(long id, String name, String lastName, String lastName2, String email, String phone, Date birthDate,
			Country country, Region region, Commune commune, Role role, long supervisorId, String nameSuper,
			String lastnameSuper, String lastName2Super) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.country = country;
		this.region = region;
		this.commune = commune;
		this.role = role;
		this.supervisorId = supervisorId;
		this.nameSuper = nameSuper;
		this.lastnameSuper = lastnameSuper;
		this.lastName2Super = lastName2Super;
	}
	public Person(String name, String lastName, String lastName2, String email, String phone, Date birthDate,
			Country country, Region region, Commune commune, Role role, long supervisorId, String nameSuper,
			String lastnameSuper, String lastName2Super) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.country = country;
		this.region = region;
		this.commune = commune;
		this.role = role;
		this.supervisorId = supervisorId;
		this.nameSuper = nameSuper;
		this.lastnameSuper = lastnameSuper;
		this.lastName2Super = lastName2Super;
	}
	public Person() {
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}
	/**
	 * @param lastName2 the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}
	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	/**
	 * @return the commune
	 */
	public Commune getCommune() {
		return commune;
	}
	/**
	 * @param commune the commune to set
	 */
	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the supervisorId
	 */
	public long getSupervisorId() {
		return supervisorId;
	}
	/**
	 * @param supervisorId the supervisorId to set
	 */
	public void setSupervisorId(long supervisorId) {
		this.supervisorId = supervisorId;
	}
	/**
	 * @return the nameSuper
	 */
	public String getNameSuper() {
		return nameSuper;
	}
	/**
	 * @param nameSuper the nameSuper to set
	 */
	public void setNameSuper(String nameSuper) {
		this.nameSuper = nameSuper;
	}
	/**
	 * @return the lastnameSuper
	 */
	public String getLastnameSuper() {
		return lastnameSuper;
	}
	/**
	 * @param lastnameSuper the lastnameSuper to set
	 */
	public void setLastnameSuper(String lastnameSuper) {
		this.lastnameSuper = lastnameSuper;
	}
	/**
	 * @return the lastName2Super
	 */
	public String getLastName2Super() {
		return lastName2Super;
	}
	/**
	 * @param lastName2Super the lastName2Super to set
	 */
	public void setLastName2Super(String lastName2Super) {
		this.lastName2Super = lastName2Super;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", lastName2=" + lastName2
				+ ", email=" + email + ", phone=" + phone + ", birthDate=" + birthDate + ", country=" + country
				+ ", region=" + region + ", commune=" + commune + ", role=" + role + ", supervisorId=" + supervisorId
				+ ", nameSuper=" + nameSuper + ", lastnameSuper=" + lastnameSuper + ", lastName2Super=" + lastName2Super
				+ "]";
	}
	
	
	
}

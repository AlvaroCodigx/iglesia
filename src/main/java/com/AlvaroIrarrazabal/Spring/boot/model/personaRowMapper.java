package com.AlvaroIrarrazabal.Spring.boot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class personaRowMapper  implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person p = new Person();
		Region region = new Region();
		Country country = new Country();
		Commune commune = new Commune();
		Role role = new Role();

		p.setId(rs.getLong("id"));
		p.setName(rs.getString("nombre"));
		p.setLastName(rs.getString("apellidoP"));
		p.setLastName2(rs.getString("apellidoM"));
		p.setEmail(rs.getString("email"));
		p.setPhone(rs.getString("telefono"));
		p.setBirthDate(rs.getDate("fechaNacimiento"));
		country.setId(rs.getLong("paisId"));
		country.setName(rs.getString("nombrePais"));
		country.setShortName(rs.getString("shortNombre"));
		p.setCountry(country);
		region.setId(rs.getLong("idRegion"));
		region.setName(rs.getString("nombreRegion"));
		region.setAbbreviation(rs.getString("shortNombreRegion"));
		p.setRegion(region);
		commune.setId(rs.getLong("idComuna"));
		commune.setName(rs.getString("nombreComuna"));
		p.setCommune(commune);
		role.setId(rs.getLong("idRol"));
		role.setName(rs.getString("nombreRol"));
		p.setRole(role);
		p.setSupervisorId(rs.getLong("idSuper"));
		p.setNameSuper(rs.getString("nombreSuper"));
		p.setLastnameSuper(rs.getString("apellidoSP"));
		p.setLastName2Super(rs.getString("apellidoSM"));
	
		
		
		
		return p;
	}


}

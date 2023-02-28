package com.AlvaroIrarrazabal.Spring.boot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PaisesRowMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		
		country.setId(rs.getLong("id"));
		country.setShortName(rs.getString("short_nombre"));
		country.setName(rs.getString("nombre"));
		
		return country;
	}

}

package com.AlvaroIrarrazabal.Spring.boot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ComunaRowMapper implements RowMapper<Commune> {

	@Override
	public Commune mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Commune commune = new Commune();
		
		commune.setId(rs.getLong("id"));
		commune.setName(rs.getString("nombre"));
		return commune;
	}
	

}

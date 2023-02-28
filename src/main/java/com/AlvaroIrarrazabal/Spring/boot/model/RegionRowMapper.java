package com.AlvaroIrarrazabal.Spring.boot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RegionRowMapper implements RowMapper<Region> {

	@Override
	public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
		Region region = new Region();
		Country country = new Country();
		
		region.setId(rs.getLong("id"));
		region.setName(rs.getString("nom"));
		region.setAbbreviation(rs.getString("abreviatura"));
		
		
		return region;
	}

}

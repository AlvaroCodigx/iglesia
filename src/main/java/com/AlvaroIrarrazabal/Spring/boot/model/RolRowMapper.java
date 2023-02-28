package com.AlvaroIrarrazabal.Spring.boot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RolRowMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		
		role.setId(rs.getLong("id_rol"));
		role.setName(rs.getString("nombre_rol"));
		return role;
	}

}

//package com.AlvaroIrarrazabal.Spring.boot.model;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//public class SupervisionRowMapper implements RowMapper<Supervisor> {
//
//	@Override
//	public Supervisor mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Supervisor supervisor = new Supervisor();
//		supervisor.setId(rs.getLong("id"));
//		supervisor.setName(rs.getString("nombre"));
//		supervisor.setLastname(rs.getString("apellidoP"));
//		supervisor.setLastName2(rs.getString("apellidoM"));
//		return supervisor;
//	}
//
//}

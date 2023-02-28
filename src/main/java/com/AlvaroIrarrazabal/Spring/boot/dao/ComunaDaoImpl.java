package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.AlvaroIrarrazabal.Spring.boot.model.Commune;
import com.AlvaroIrarrazabal.Spring.boot.model.ComunaRowMapper;
import com.AlvaroIrarrazabal.Spring.boot.model.Country;
import com.AlvaroIrarrazabal.Spring.boot.model.personaRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ComunaDaoImpl implements ComunaDao {
	
	
	@Autowired
	JdbcTemplate jdbctemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Commune> findAll(Long id) {
		try {
			String sql = "SELECT * FROM comuna where id_region =?;";

			return this.jdbctemplate.query(sql, new ComunaRowMapper(),id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public List<Commune> find() {
		String sql = "SELECT * FROM comuna";
		return this.jdbctemplate.query(sql, new RowMapper<Commune>() {

			@Override
			public Commune mapRow(ResultSet rs, int rowNum) throws SQLException {

				Commune commune = new Commune();
				commune.setId(rs.getLong("id"));
				commune.setName(rs.getString("nombre"));
				return commune;

			}
		});
	}

	}



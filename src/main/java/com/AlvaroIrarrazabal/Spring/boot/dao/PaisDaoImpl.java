package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.AlvaroIrarrazabal.Spring.boot.model.Country;
import com.AlvaroIrarrazabal.Spring.boot.model.PaisesRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PaisDaoImpl implements PaisDAO {

	@Autowired
	JdbcTemplate jdbctemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Country> findAlPais() {
		String sql = "SELECT * FROM pais";
		return this.jdbctemplate.query(sql, new RowMapper<Country>() {

			@Override
			public Country mapRow(ResultSet rs, int rowNum) throws SQLException {

				Country country = new Country();
				country.setId(rs.getLong("id"));
				country.setShortName(rs.getString("short_nombre"));
				country.setName(rs.getString("nombre"));
				return country;

			}
		});
	}


	

	


	@Override
	public Country save(Country country) {

		String sql = "INSERT INTO pais (short_nombre,nombre) values (?,?)";
		jdbctemplate.update(sql, new Object[] { country.getShortName(), country.getName() });

		return country;

	}

	@Override
	public int update(Country country) {
		String sql = "UPDATE pais SET short_nombre=?,nombre=? where id=? ";

		return jdbctemplate.update(sql,
				new Object[] { country.getShortName(), country.getName(), country.getId() });

	}

	@Override
	public Country findById(Long id) {

		try {
			String sql = "SELECT * FROM pais WHERE id=?";
			return this.jdbctemplate.queryForObject(sql, new PaisesRowMapper(), id);
		} catch (IncorrectResultSizeDataAccessException e) {
			e.printStackTrace(System.out);
		}
		return null;
	}

	@Override
	public int delete(Long id) {
		
		String sql = "DELETE FROM pais WHERE id=?";
		return jdbctemplate.update(sql,id);
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

}

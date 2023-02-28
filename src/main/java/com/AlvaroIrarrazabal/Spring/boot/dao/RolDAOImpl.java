package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.AlvaroIrarrazabal.Spring.boot.model.Role;
import com.AlvaroIrarrazabal.Spring.boot.model.RolRowMapper;

@Repository
public class RolDAOImpl implements RolDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Role> findAll() {
		String sql = "SELECT * FROM rol";

		return this.jdbcTemplate.query(sql, new RowMapper<Role>() {

			@Override
			public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
				Role role = new Role();

				role.setId(rs.getLong("id"));
				role.setName(rs.getString("nombre"));
				return role;
			}

		});

	}

	@Override
	public Role save(Role role) {
		String sql = "INSERT INTO rol (nombre) values(?)";

		jdbcTemplate.update(sql, new Object[] { role.getName() });
		return role;
	}

	@Override
	public int update(Role role) {
		String sql = "UPDATE rol SET nombre=? where id=? ";

		return jdbcTemplate.update(sql, new Object[] { role.getName(), role.getId() });

	}

	@Override
	public Role findById(Long id) {
		try {

			String sql = "SELECT *  from rol where id =?";
			return this.jdbcTemplate.queryForObject(sql, new RolRowMapper(), id);
			
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

	}

	@Override
	public int delete(Long id) {
		String sql="DELETE FROM rol where id=?";
		return jdbcTemplate.update(sql,id);
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

}

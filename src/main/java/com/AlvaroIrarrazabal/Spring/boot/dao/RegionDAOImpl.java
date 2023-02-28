package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.AlvaroIrarrazabal.Spring.boot.model.Country;
import com.AlvaroIrarrazabal.Spring.boot.model.PaisesRowMapper;
import com.AlvaroIrarrazabal.Spring.boot.model.Region;
import com.AlvaroIrarrazabal.Spring.boot.model.RegionRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class RegionDAOImpl implements RegionDao {
	@Autowired
	JdbcTemplate jdbctemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Region> findAll() {
		
		String sql="SELECT * FROM region";				
	
		return this.jdbctemplate.query(sql, new RowMapper<Region>() {

			@Override
			public Region mapRow(ResultSet rs, int rowNum) throws SQLException {

				Region region = new Region();
				region.setId(rs.getLong("id"));
				region.setName(rs.getString("nombre"));
				region.setAbbreviation(rs.getString("abreviatura"));

				return region;
			}
			
		});
	}
	
	
	@Override
	public List<Region> findById(Long id) {

		try {
			String sql = "SELECT re.nombre as nom, re.abreviatura, re.id as id "
					+ " from region as re "
					+ "  inner join pais as pa on (re.id_pais = pa.id) where pa.id = ?";
			return this.jdbctemplate.query(sql, new RegionRowMapper(),id);
		} catch (IncorrectResultSizeDataAccessException e) {
			e.printStackTrace(System.out);
		}
		return null;
	}


	
}

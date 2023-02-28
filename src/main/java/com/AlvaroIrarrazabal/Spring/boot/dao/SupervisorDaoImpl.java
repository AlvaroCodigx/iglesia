//package com.AlvaroIrarrazabal.Spring.boot.dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import com.AlvaroIrarrazabal.Spring.boot.model.SupervisionRowMapper;
//import com.AlvaroIrarrazabal.Spring.boot.model.Supervisor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class SupervisorDaoImpl implements SupervisorDAO {
//
//	@Autowired
//	private JdbcTemplate jdbctemplate;
//
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbctemplate = new JdbcTemplate(dataSource);
//	}
//
//	@Override
//	public List<Supervisor> findAll() {
//
//		String sql = "SELECT * FROM supervisor";
//
//		return this.jdbctemplate.query(sql, new RowMapper<Supervisor>() {
//
//			@Override
//			public Supervisor mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Supervisor supervisor = new Supervisor();
//				supervisor.setId(rs.getLong("id"));
//				supervisor.setName(rs.getString("nombre"));
//				supervisor.setLastname(rs.getString("apellidoP"));
//				supervisor.setLastName2(rs.getString("apellidoM"));
//
//				return supervisor;
//			}
//
//		});
//	}
//
//	@Override
//	public Supervisor save(Supervisor supervisor) {
//		String sql = "INSERT INTO supervisor (nombre,apellidoP,apellidoM)" + "VALUES(?,?,?)";
//
//		jdbctemplate.update(sql, new Object[] { supervisor.getName(), supervisor.getLastname(),supervisor.getLastName2() });
//
//		return supervisor;
//	}
//
//	@Override
//	public int update(Supervisor supervisor) {
//		String sql = "UPDATE supervisor SET nombre=?,apellidoP=?,apellidoM=? WHERE id=?";
//
//		return jdbctemplate.update(sql, new Object[] { supervisor.getName(),
//				supervisor.getLastname(),supervisor.getLastName2(), supervisor.getId() });
//	}
//
//	@Override
//	public Supervisor findById(Long id) {
//
//			String sql="SELECT * FROM supervisor WHERE id=?";
//			
//			return jdbctemplate.queryForObject(sql,new SupervisionRowMapper(),id);
//		
//	}
//
//	@Override
//	public int delete(Long id) {
//		String sql="DELETE FROM supervisor where id=?";
//		return jdbctemplate.update(sql,id);
//	}
//
//	@Override
//	public int deleteAll() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//}

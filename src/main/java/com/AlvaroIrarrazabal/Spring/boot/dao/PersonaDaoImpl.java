package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.AlvaroIrarrazabal.Spring.boot.controller.PersonaController;
import com.AlvaroIrarrazabal.Spring.boot.model.Commune;
import com.AlvaroIrarrazabal.Spring.boot.model.Country;
import com.AlvaroIrarrazabal.Spring.boot.model.Person;
import com.AlvaroIrarrazabal.Spring.boot.model.PerssonaSupervisorRowMaper;
import com.AlvaroIrarrazabal.Spring.boot.model.Region;
import com.AlvaroIrarrazabal.Spring.boot.model.Role;
//import com.AlvaroIrarrazabal.Spring.boot.model.Supervisor;
import com.AlvaroIrarrazabal.Spring.boot.model.personaRowMapper;

@Repository
public class PersonaDaoImpl implements PersonaDAO {
	
	private static final Logger LOGGER = Logger.getLogger(PersonaController.class);


	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	Person person = new Person();

	@Override
	public List<Person> findAll() {
		String sql = "select per.id, per.nombre , per.apellidoP,per.apellidoM,per.email,per.telefono,per.fechaNacimiento,"
				+ "	pais.id as paisId, pais.abreviatura as shortNombre,pais.nombre as nombrePais,	"
				+ "	region.id as idRegion,region.abreviatura as shortNombreRegion, region.nombre as nombreRegion,"
				+ "	comuna.id as idComuna,comuna.nombre as nombreComuna,"
				+ "	rp.id as idRol,rp.nombre as nombreRol , persuper.id as idSuper ,"
				+ "	persuper.nombre as nombreSuper,persuper.apellidoP  as apellidoSP,persuper.apellidoM as apellidoSM "
				+ "	from persona as per "
				+ " inner join  persona as persuper on (persuper.id=per.supervisor_id) "
				+ "	inner join  rol as rp on (per.rol_id=rp.id) "
				+ "	inner join  pais as pais on (per.pais_id=pais.id) "
				+ "	inner join  region as region on (region.id=per.region_id) "
				+ "	inner join  comuna as comuna on (comuna.id=per.comuna_id)    ORDER BY per.nombre asc ";
		
		LOGGER.info("Se recuperaron los datos de las personas: "+sql);			

		return seleccionarPersonas(sql);
	}

	@Override
	public List<Person> findCumpleaños() {
		String sql = "select per.id, per.nombre , per.apellidoP,per.apellidoM,per.email,per.telefono,per.fechaNacimiento,"
				+ " pais.id as paisId, pais.abreviatura as shortNombre,pais.nombre as nombrePais,"
				+ "	region.id as idRegion,region.abreviatura as shortNombreRegion, region.nombre as nombreRegion,"
				+ "	comuna.id as idComuna,comuna.nombre as nombreComuna,"
				+ "	rp.id as idRol,rp.nombre as nombreRol ,per.supervisor_id as idSuper,"
				+ "	persuper.nombre as nombreSuper,persuper.apellidoP  as apellidoSP,persuper.apellidoM as apellidoSM "
				+ "	from persona as per "
				+ "	inner join  persona as persuper on (persuper.id=per.supervisor_id) "
				+ "	inner join  rol as rp on (per.rol_id=rp.id) "
				+ "	inner join  pais as pais on (per.pais_id=pais.id) "
				+ "	inner join  region as region on (region.id=per.region_id) "
				+ "	inner join  comuna as comuna on (comuna.id=per.comuna_id)  WHERE MONTH(per.fechaNacimiento) = MONTH(CURRENT_DATE())";

		return seleccionarPersonas(sql);

	}

	public Person findbyId(Long id) {
		try {
			String sql = "select per.id, per.nombre , per.apellidoP,per.apellidoM,per.email,per.telefono,per.fechaNacimiento,"
					+ " pais.id as paisId, pais.abreviatura as shortNombre,pais.nombre as nombrePais,	"
					+ "	region.id as idRegion,region.abreviatura as shortNombreRegion, region.nombre as nombreRegion,"
					+ "	comuna.id as idComuna,comuna.nombre as nombreComuna,"
					+ "	rp.id as idRol,rp.nombre as nombreRol ,per.supervisor_id as idSuper,"
					+ "	persuper.nombre as nombreSuper,persuper.apellidoP  as apellidoSP,persuper.apellidoM as apellidoSM "
					+ "	from persona as per "
					+ "	inner join  persona as persuper on (persuper.id=per.supervisor_id) "
					+ "	inner join  rol as rp on (per.rol_id=rp.id) "
					+ "	inner join  pais as pais on (per.pais_id=pais.id) "
					+ "	inner join  region as region on (region.id=per.region_id) "
					+ "	inner join  comuna as comuna on (comuna.id=per.comuna_id)  where per.id=? ";

			return this.jdbctemplate.queryForObject(sql, new personaRowMapper(), id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Person> findSuperByRol(String st) {

		try {
			String sql = " select per.id, per.nombre , per.apellidoP,per.apellidoM,per.email,per.telefono,per.fechaNacimiento,"
					+ "	pais.id as paisId, pais.abreviatura as shortNombre,pais.nombre as nombrePais,	"
					+ "	region.id as idRegion,region.abreviatura as shortNombreRegion, region.nombre as nombreRegion,"
					+ "	comuna.id as idComuna,comuna.nombre as nombreComuna,"
					+ "	rp.id as idRol,rp.nombre as nombreRol ,per.supervisor_id as idSuper,"
					+ "	persuper.nombre as nombreSuper,persuper.apellidoP  as apellidoSP,persuper.apellidoM as apellidoSM "
					+ "	from persona as per "
					+ "	inner join  persona as persuper on (persuper.id=per.supervisor_id) "
					+ "	inner join  rol as rp on (per.rol_id=rp.id) "
					+ "	inner join  pais as pais on (per.pais_id=pais.id) "
					+ "	inner join  region as region on (region.id=per.region_id) "
					+ "	inner join  comuna as comuna on (comuna.id=per.comuna_id)   where rp.nombre=?";

			return this.jdbctemplate.query(sql, new PerssonaSupervisorRowMaper(), st);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

	}

	@Override
	public List<Person> findSupervisado(Long id) {

		try {
			String sql = " select per.id, per.nombre , per.apellidoP,per.apellidoM,per.email,per.telefono,per.fechaNacimiento, "
					+ "	pais.id as paisId, pais.abreviatura as shortNombre,pais.nombre as nombrePais,	"
					+ "	region.id as idRegion,region.abreviatura as shortNombreRegion, region.nombre as nombreRegion,"
					+ "	comuna.id as idComuna,comuna.nombre as nombreComuna, "
					+ "	rp.id as idRol,rp.nombre as nombreRol ,per.supervisor_id as idSuper , "
					+ "	persuper.nombre as nombreSuper,persuper.apellidoP  as apellidoSP,persuper.apellidoM as apellidoSM "
					+ "	from persona as persuper  "
					+ "	inner join  persona as per on (persuper.id=per.supervisor_id) "
					+ "	inner join  rol as rp on (per.rol_id=rp.id)  "
					+ "	inner join  pais as pais on (per.pais_id=pais.id) "
					+ "	inner join  region as region on (region.id=per.region_id) "
					+ "	inner join  comuna as comuna on (comuna.id=per.comuna_id)   WHERE per.supervisor_id = ?";
			
			return this.jdbctemplate.query(sql, new PerssonaSupervisorRowMaper(), id);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

	}

	public Person save(Person person) {

		String sql = "INSERT INTO PERSONA( nombre, apellidoP,apellidoM, email, telefono, fechaNacimiento,"
				+ "pais_id, region_id,comuna_id,rol_id,supervisor_id)values (?,?,?,?,?,?,?,?,?,?,?) ";
		jdbctemplate.update(sql,
				new Object[] { person.getName(), person.getLastName(), person.getLastName2(), person.getEmail(),
						person.getPhone(), person.getBirthDate(), person.getCountry().getId(),
						person.getRegion().getId(), person.getCommune().getId(), person.getRole().getId(),
						person.getSupervisorId() });
		return person;
	}

	public int update(Person person) {
		String sql = "UPDATE PERSONA SET  nombre=?, apellidoP=?,apellidoM=?"
				+ ", email=?, telefono=?, fechaNacimiento=? ,pais_id=?,region_id=?,comuna_id=?,rol_id=?,supervisor_id=? WHERE  persona.id = ?";

		return jdbctemplate.update(sql,
				new Object[] { person.getName(), person.getLastName(), person.getLastName2(), person.getEmail(),
						person.getPhone(), person.getBirthDate(), person.getCountry().getId(),
						person.getRegion().getId(), person.getCommune().getId(), person.getRole().getId(),
						person.getSupervisorId(), person.getId() });

	}

	public int delete(Long id) {
		String sql = "DELETE  FROM PERSONA WHERE id=?";

		return jdbctemplate.update(sql, id);

	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	private List<Person> seleccionarPersonas(String sql) {
		return this.jdbctemplate.query(sql, new RowMapper<Person>() {
			@Override
			public Person mapRow(ResultSet rs, int i) throws SQLException {

				Person p = new Person();
				Region region = new Region();
				Country country = new Country();
				Commune commune = new Commune();
				Role role = new Role();

				p.setId(rs.getLong("id"));
				p.setName(rs.getString("nombre"));
				p.setLastName(rs.getString("apellidoP"));
				p.setLastName2(rs.getString("apellidoM"));
				p.setEmail(rs.getString("email"));
				p.setPhone(rs.getString("telefono"));
				p.setBirthDate(rs.getDate("fechaNacimiento"));
				country.setId(rs.getLong("paisId"));
				country.setName(rs.getString("nombrePais"));
				country.setShortName(rs.getString("shortNombre"));
				p.setCountry(country);
				region.setId(rs.getLong("idRegion"));
				region.setName(rs.getString("nombreRegion"));
				region.setAbbreviation(rs.getString("shortNombreRegion"));
				p.setRegion(region);
				commune.setId(rs.getLong("idComuna"));
				commune.setName(rs.getString("nombreComuna"));
				p.setCommune(commune);
				role.setId(rs.getLong("idRol"));
				role.setName(rs.getString("nombreRol"));
				p.setRole(role);
				p.setSupervisorId(rs.getLong("idSuper"));
				p.setNameSuper(rs.getString("nombreSuper"));
				p.setLastnameSuper(rs.getString("apellidoSP"));
				p.setLastName2Super(rs.getString("apellidoSM"));

				return p;
			}

		});
	}

}

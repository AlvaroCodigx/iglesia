package com.AlvaroIrarrazabal.Spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlvaroIrarrazabal.Spring.boot.dao.PersonaDaoImpl;
import com.AlvaroIrarrazabal.Spring.boot.model.Person;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PersonaController {

	
	private static final Logger LOGGER = Logger.getLogger(PersonaController.class);
	@Autowired
	PersonaDaoImpl personadao;
	Person person = new Person();

	@GetMapping("/personas")
	public List<Person> getPersonas() {

		LOGGER.info("Se recuperaron los datos de las personas "+personadao.findAll());
		return personadao.findAll();

	}
	@GetMapping("/personasCumple")
	public List<Person> getMesCumpleaños() {
		LOGGER.info("Se recuperaron los datos de los cumpleaños "+personadao.findCumpleaños());

		return personadao.findCumpleaños();

	}

	@PostMapping("/personas")
	public ResponseEntity<Map<String, Object>> crearPersona(@RequestBody Person person) {

		Map<String, Object> response = new HashMap<>();
		try {
			personadao.save(new Person (person.getName(),person.getLastName(),
					person.getLastName2(),person.getEmail(),person.getPhone(),person.getBirthDate(),
					person.getCountry(),person.getRegion(),person.getCommune(),person.getRole(),person.getSupervisorId(),person.getNameSuper(),person.getLastnameSuper(),
					person.getLastName2Super()));
			LOGGER.info("Datos de la persona "+person.toString());

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			LOGGER.error("No se ha guardado a la persona "+person.toString());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.put("mensaje", "La Persona fue creada con exito");
		LOGGER.info("se ha guardado exitosamente la persona "+person.toString());


		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}

	@GetMapping("/personas/{id}")
	public ResponseEntity<?> obtenerPersonaPorId(@PathVariable long id) {
		Person person = null;

		Map<String, Object> response = new HashMap<>();
		try {
			person = personadao.findbyId(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consult en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		if (person == null) {
			response.put("mensaje", "La persona con el ID no existe ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		} else {

			response.put("mensaje", "La persona fue encontrada con exito");
			return new ResponseEntity<Person>(person, HttpStatus.OK);

		}
	}
	
	@GetMapping("/personaSupervisada/{st}")
	public ResponseEntity<?> obtenerSupervisorPorRol(@PathVariable String st) {
		List<Person> person = null;

		Map<String, Object> response = new HashMap<>();
		try {
			person = personadao.findSuperByRol(st);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		if (person != null ) {
			response.put("mensaje", "La persona fue encontrada con exito");
			return new ResponseEntity<List<Person>>(person, HttpStatus.OK);
			

		} else {
			response.put("mensaje", "El supervisor con ID "+st+" no existe ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			

		}
	}
	

	@GetMapping("/supervisado/{id}")
	public ResponseEntity<?> obtenerSupervisadoPorId(@PathVariable Long id) {
		List<Person> person = null;

		Map<String, Object> response = new HashMap<>();
		try {
			person = personadao.findSupervisado(id);
			LOGGER.info("Personas con id del supervisor :"+person.toString());


		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
		LOGGER.error("error al seleccionar a las personas supervisadas"+person.toString());


			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		response.put("mensaje", "La persona fue encontrada con exito");
	LOGGER.info("Personas encontradas  "+person.toString());

		return new ResponseEntity<List<Person>>(person, HttpStatus.OK);
	}

	@PutMapping("/personas/{id}")
	public ResponseEntity<?> updatePersona(@PathVariable("id") long id, @RequestBody Person person) {

		Map<String, Object> response = new HashMap<>();
		Person _persona = personadao.findbyId(id);

		if (_persona != null) {
			_persona.setId(id);
			_persona.setName(person.getName());
			_persona.setLastName(person.getLastName());
			_persona.setLastName2(person.getLastName2());
			_persona.setEmail(person.getEmail());
			_persona.setPhone(person.getPhone());
			_persona.setBirthDate(person.getBirthDate());
			_persona.setCountry(person.getCountry());
			_persona.setRegion(person.getRegion());
			_persona.setCommune(person.getCommune());
			_persona.setRole(person.getRole());
			_persona.setSupervisorId(person.getSupervisorId());
			personadao.update(_persona);
			response.put("mensaje", "La persona fue editada con exito");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} else {
			response.put("mensaje", "No se encontró a la persona con el id = " + id);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
	}

	@DeleteMapping("/personas/{id}")
	public ResponseEntity<?> borrarPersona(@PathVariable("id") long id) {

		Map<String, Object> response = new HashMap<>();
		try {
			
		
			
			int result = personadao.delete(id);
			if (result == 0) {
				response.put("mensaje", "No se encontro a la persona seleccionada");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			response.put("mensaje", "La persona se elimino con exito");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", "Error al buscar a la persona en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

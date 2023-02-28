package com.AlvaroIrarrazabal.Spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.AlvaroIrarrazabal.Spring.boot.dao.RolDAOImpl;
import com.AlvaroIrarrazabal.Spring.boot.model.Person;
import com.AlvaroIrarrazabal.Spring.boot.model.Role;

@RestController
@CrossOrigin(origins = ("*"))
@RequestMapping("/api")
public class RollController {

	@Autowired
	RolDAOImpl roldao;

	@GetMapping("/roles")
	public List<Role> getRol() {
		return roldao.findAll();

	}

	@PostMapping("/rols")
	public ResponseEntity<Map<String, Object>> crearRol(@RequestBody Role role) {

		Map<String, Object> response = new HashMap<>();

		try {
			roldao.save(new Role());

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El Rol fue creada con exito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("/rols/{id}")
	public ResponseEntity<?> updateRol(@PathVariable("id") Long id, @RequestBody Role role) {

		Map<String, Object> response = new HashMap<>();
		Role _rol = roldao.findById(id);

		if (_rol != null) {
			_rol.setId(id);
			_rol.setName(role.getName());
			roldao.update(_rol);
			response.put("mensaje", "El rol fue editado con exito");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} else {
			response.put("mensaje", "No se encontro el rol con el id " + id);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/rols/{id}")
	public ResponseEntity<?> obtenerRolPorId(@PathVariable long id) {

		Role role = null;

		Map<String, Object> response = new HashMap<>();
		try {

			role = roldao.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consulta a la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		if (role == null) {
			response.put("mensaje", "El rol con el ID no existe ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}

		response.put("mensaje", "El rol fue encontrada con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);


	}
	
	
	
	@DeleteMapping("/rols/{id}")
	public ResponseEntity<?> borrarRol(@PathVariable("id") long id){
		
		Map<String , Object> response = new HashMap<>();
		try {
			int result = roldao.delete(id);
			if(result==0) {
				response.put("mensaje", "No se encontro el Rol seleccionado");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			response.put("mensaje", "El Rol se elimino con exito");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			response.put("mensaje", "Error al buscar el Rol en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	

}

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

import com.AlvaroIrarrazabal.Spring.boot.dao.PaisDAO;
import com.AlvaroIrarrazabal.Spring.boot.model.Country;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class PaisController {

	@Autowired
	PaisDAO paisdao;

	@GetMapping("/paises")
	public List<Country> getPaises() {
		return paisdao.findAlPais();
	}

	@PostMapping("/paises")
	public ResponseEntity<Map<String, Object>> crearPais(@RequestBody Country country) {

		Map<String, Object> response = new HashMap<>();

		try {
			paisdao.save(new Country(country.getShortName(), country.getName()));

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El pais fue creada con exito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("/paises/{id}")
	public ResponseEntity<?> updatePais(@PathVariable("id") Long id, @RequestBody Country country) {

		Map<String, Object> response = new HashMap<>();

		Country pais = paisdao.findById(id);

		if (pais != null) {
			pais.setId(id);
			pais.setShortName(country.getShortName());
			pais.setName(country.getName());
			paisdao.update(pais);
			response.put("mensaje", "El pais fue editada con exito");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} else {
			response.put("mensaje", "No se encontro el pais con el id " + id);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

	}
	
	
	
	@GetMapping("/paises/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable long id){
		Country country = null;
		Map<String, Object> response = new HashMap<>();
		try {
			country = paisdao.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consult en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(country == null) {
			response.put("mensaje", "El pais con el ID "+id+" no existe ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}else {
			response.put("mensaje", "El pais se encontro con exito ");
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/paises/{id}")
	public ResponseEntity<?>eliminar(@PathVariable("id") long id){
		
		Map<String, Object> response = new HashMap<>();
		try {
			int result = paisdao.delete(id);
			if(result ==0) {
				response.put("mensaje", "No se encontro el Pais seleccionada");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);			
			}
			response.put("mensaje", "El Pais se elimino con exito");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", "Error al buscar el Pais en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

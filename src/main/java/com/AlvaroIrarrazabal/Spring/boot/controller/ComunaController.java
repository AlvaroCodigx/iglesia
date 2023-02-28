package com.AlvaroIrarrazabal.Spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.AlvaroIrarrazabal.Spring.boot.dao.ComunaDao;
import com.AlvaroIrarrazabal.Spring.boot.model.Commune;
import com.AlvaroIrarrazabal.Spring.boot.model.Country;
import com.AlvaroIrarrazabal.Spring.boot.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class ComunaController {
	
	
	@Autowired
	ComunaDao comunaDao;
	
	
	
	@GetMapping("/comunas")
	public List<Commune> getComunas() {
		return comunaDao.find();
	}
	
	@GetMapping("/comunas/{id}")
	public  ResponseEntity<?>  getComunas( @PathVariable long id) {
		 List<Commune>commune = null;
		 
		 Map<String,Object> response = new HashMap<>();
		 
		try {
			 commune = comunaDao.findAll(id);
			 
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (commune != null) {
			response.put("mensaje", "Las comunas se econtraron con exito");
			return new ResponseEntity<List<Commune>>(commune, HttpStatus.OK);
			

		} else {
			response.put("mensaje", "La comuna con ID "+id+" no existe ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			

		}
		 
		 
	}
	
	
	
	
	
	
	
	

}







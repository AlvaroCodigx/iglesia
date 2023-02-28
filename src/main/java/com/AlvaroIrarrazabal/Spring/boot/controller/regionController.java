	package com.AlvaroIrarrazabal.Spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.AlvaroIrarrazabal.Spring.boot.dao.RegionDao;
import com.AlvaroIrarrazabal.Spring.boot.model.Country;
import com.AlvaroIrarrazabal.Spring.boot.model.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class regionController {
	
	@Autowired
	RegionDao regionDao;
	
	@GetMapping("/regiones")
	public List<Region> getRegion() {
		return regionDao.findAll();
	}
	
	@GetMapping("/regiones/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
		List<Region> region = null;
		Map<String, Object> response = new HashMap<>();
		try {
			region = regionDao.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al hacer la consult en la base de datos");
			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(region == null) {
			response.put("mensaje", "La region con el ID "+id+" no existe ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}else {
			response.put("mensaje", "La region se encontro con exito ");
			return new ResponseEntity<List<Region>>(region, HttpStatus.OK);
		}

	}

}

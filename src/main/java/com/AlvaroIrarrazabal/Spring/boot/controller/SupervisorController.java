//package com.AlvaroIrarrazabal.Spring.boot.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.AlvaroIrarrazabal.Spring.boot.dao.SupervisorDaoImpl;
//import com.AlvaroIrarrazabal.Spring.boot.model.Supervisor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api")
//public class SupervisorController {
//	
//	@Autowired
//	SupervisorDaoImpl superdao;
//
//	@GetMapping("/supervisores")
//	public List<Supervisor> getPersonas() {
//
//		return superdao.findAll();
//
//	}
//	
//	
//	@PostMapping("/supervisores")
//	public ResponseEntity<Map<String, Object>>crearSupervisor(@RequestBody Supervisor supervisor){
//		
//		Map<String, Object> response = new HashMap<>();
//		
//		try {
//			superdao.save(new Supervisor(supervisor.getName(),supervisor.getLastname(),supervisor.getLastName2()));
//			
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al hacer la consulta en la base de datos");
//			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		response.put("mensaje", "El supervisor fue creado con exito");
//
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//		
//	} 
//	
//	@GetMapping("/supervisores/{id}")
//	public ResponseEntity<?>buscarPorId(@PathVariable("id") Long id){
//		
//		Supervisor supervisor=null;
//		Map<String, Object> response = new HashMap<>();
//		
//		try {
//			supervisor = superdao.findById(id);
//		} catch (DataAccessException e) {
//			response.put("mensaje", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
//			response.put("mensaje", "Error al hacer la consulta en la base de datos");
//
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		if(supervisor == null) {
//			response.put("mensaje", "El supervisor con el ID  "+id+" no existe ");
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//		}else {
//			response.put("mensaje", "El Supervisor fue encontrado con exito ");
//			return new ResponseEntity<Supervisor>(supervisor, HttpStatus.OK);
//		}
//		
//	}
//	
//	
//	
//	
//	
//	
//	@PutMapping("/supervisores/{id}")
//	public ResponseEntity<?>editarSupervisor(@PathVariable("id") Long id, @RequestBody Supervisor supervisor){
//		
//		Map<String, Object> response = new HashMap<>();
//		
//		Supervisor _supervisor = superdao.findById(id);
//		
//		if(_supervisor!=null) {
//			_supervisor.setName(supervisor.getName());
//			_supervisor.setLastname(supervisor.getLastname());
//			_supervisor.setLastName2(supervisor.getLastName2());
//			superdao.update(_supervisor);
//			response.put("mensaje", "El supervisor fue editado con exito");
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//		}else {
//			response.put("mensaje", "No se encontró a el supervisor con el id = " + id);
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//		}
//		
//		
//	}
//	
//	@DeleteMapping("/supervisores/{id}")
//	public ResponseEntity<?> borrarSupervisor(@PathVariable("id") Long id){
//		
//		Map<String, Object> response = new HashMap<>();
//		try {
//			int result = superdao.delete(id);
//			if (result == 0) {
//				response.put("mensaje", "No se encontro al supervisor seleccionado");
//				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//			}
//			response.put("mensaje", "El supervisor se elimino con exito");
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//		} catch (Exception e) {
//			response.put("mensaje", "Error al buscar al supervisor en la base de datos");
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}

package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.util.List;

import com.AlvaroIrarrazabal.Spring.boot.model.Commune;
import com.AlvaroIrarrazabal.Spring.boot.model.Country;
import com.AlvaroIrarrazabal.Spring.boot.model.Person;
import com.AlvaroIrarrazabal.Spring.boot.model.Region;
import com.AlvaroIrarrazabal.Spring.boot.model.Role;




public interface PersonaDAO   {
	
	List<Person>findAll();
	
	List<Person>findCumpleaños();
	
	Person save(Person person);
	
	int update(Person person);
	
	int delete(Long id);
	
	int deleteAll();
	
	Person findbyId(Long id);
	
	List<Person>findSuperByRol(String st);
	
	List<Person>findSupervisado(Long id);


}

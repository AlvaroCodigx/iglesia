package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.util.List;

import com.AlvaroIrarrazabal.Spring.boot.model.Country;

public interface PaisDAO   {
	
	List<Country> findAlPais();
	Country save(Country country);
	Country findById(Long id);
	int update(Country country);
	int delete(Long id);
	int deleteAll();
	

}

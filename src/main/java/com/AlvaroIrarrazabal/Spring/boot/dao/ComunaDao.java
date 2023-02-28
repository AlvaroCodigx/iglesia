package com.AlvaroIrarrazabal.Spring.boot.dao;


import java.util.List;

import com.AlvaroIrarrazabal.Spring.boot.model.Commune;



public interface ComunaDao {
	
	List<Commune>findAll(Long id);
	List<Commune>find();

}

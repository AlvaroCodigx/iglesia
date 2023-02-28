package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.util.List;

import com.AlvaroIrarrazabal.Spring.boot.model.Region;





public interface RegionDao {
	
	List<Region>findAll();
	List<Region> findById(Long id);

	

}

package com.AlvaroIrarrazabal.Spring.boot.dao;

import java.util.List;

import com.AlvaroIrarrazabal.Spring.boot.model.Role;

public interface RolDao {
	
	
	List<Role>findAll();
	Role save(Role role);
	int update(Role role);
	Role findById(Long id);
	int delete(Long id);
	int deleteAll();

}

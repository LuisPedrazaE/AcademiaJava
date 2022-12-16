package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import com.luv2code.springboot.cruddemo.entity.Huesped;

public interface HuespedDAO {

	List<Huesped> findAll();
	
	Huesped findById(int theId);
	
	void save(Huesped theHuesped);
	
	void deleteById(int theId);
	
}

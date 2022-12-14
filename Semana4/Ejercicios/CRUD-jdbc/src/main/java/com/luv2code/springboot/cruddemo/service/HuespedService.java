package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Huesped;

public interface HuespedService {

	public List<Huesped> findAll();
	
	public Huesped findById(int theId);
	
	public void save(Huesped theHuesped);
	
	public void deleteById(int theId);
	
}

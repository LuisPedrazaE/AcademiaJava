package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.model.Huesped;

public interface HuespedService {

	public List<Huesped> getHuespedes();

	public void saveHuesped(Huesped theHuesped);

	public Huesped getHuesped(int theId);

	public void deleteHuesped(int theId);
	
}

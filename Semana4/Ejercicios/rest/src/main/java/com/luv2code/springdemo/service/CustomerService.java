package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.model.Huesped;

public interface CustomerService {

	public List<Huesped> getCustomers();

	public void saveCustomer(Huesped theCustomer);

	public Huesped getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}

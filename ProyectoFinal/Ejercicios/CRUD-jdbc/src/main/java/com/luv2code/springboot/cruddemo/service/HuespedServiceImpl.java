package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.HuespedDAO;
import com.luv2code.springboot.cruddemo.entity.Huesped;

@Service
public class HuespedServiceImpl implements HuespedService {

	
	private HuespedDAO huespedDAO;
	
	@Autowired
	public HuespedServiceImpl(@Qualifier("huespedDAOJdbcImpl") HuespedDAO theHuespedDAO) {
		huespedDAO = theHuespedDAO;
	}
	
	@Override
	@Transactional
	public List<Huesped> findAll() {
		return huespedDAO.findAll();
	}

	@Override
	@Transactional
	public Huesped findById(int theId) {
		return huespedDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Huesped theHuesped) {
		huespedDAO.save(theHuesped);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		huespedDAO.deleteById(theId);
	}

}







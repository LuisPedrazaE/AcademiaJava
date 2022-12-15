package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Huesped;
import com.luv2code.springboot.cruddemo.service.HuespedService;

@RestController
@RequestMapping("/rest")
public class HuespedRestController {

	private HuespedService huespedService;
	
	@Autowired
	public HuespedRestController(HuespedService theHuespedService) {
		huespedService = theHuespedService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/huespedes")
	public List<Huesped> findAll() {
		return huespedService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/huespedes/{huespedId}")
	public Huesped getHuesped(@PathVariable int huespedId) throws Exception {
		
		Huesped theHuesped = huespedService.findById(huespedId);
		
		if (theHuesped == null) {
			throw new Exception("Huesped id not found - " + huespedId);
		}
		
		return theHuesped;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/huespedes")
	public Huesped addHuesped(@RequestBody Huesped theHuesped) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theHuesped.setId(0);
		
		huespedService.save(theHuesped);
		
		return theHuesped;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/huespedes")
	public Huesped updateHuesped(@RequestBody Huesped theHuesped) {
		
		
		huespedService.save(theHuesped);
		
		return theHuesped;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/huespedes/{huespedId}")
	public String deleteHuesped(@PathVariable int huespedId) {
		
		Huesped tempHuesped = huespedService.findById(huespedId);
		
		// throw exception if null
		
		if (tempHuesped == null) {
			throw new RuntimeException("Huesped id not found - " + huespedId);
		}
		
		huespedService.deleteById(huespedId);
		
		return "Deleted huesped id - " + huespedId;
	}
	
}











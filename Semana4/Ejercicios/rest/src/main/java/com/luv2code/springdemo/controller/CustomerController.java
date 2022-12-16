package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.model.Huesped;
import com.luv2code.springdemo.service.HuespedService;

@Controller
@RequestMapping("/huesped")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private HuespedService huespedService;
	
	@GetMapping("/list")
	public String listHuespedes(Model theModel) {
		
		// get huespedes from the service
		List<Huesped> theHuespedes = huespedService.getHuespedes();
				
		// add los huespedes to the model
		theModel.addAttribute("huespedes", theHuespedes);
		
		return "list-huespedes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Huesped theHuesped = new Huesped();
		
		theModel.addAttribute("huesped", theHuesped);
		
		return "huesped-form";
	}
	
	@PostMapping("/saveHuesped")
	public String saveHuesped(@ModelAttribute("huesped") Huesped theHuesped) {
		
		// save the customer using our service
		huespedService.saveHuesped(theHuesped);	
		
		return "redirect:/huesped/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("huespedId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Huesped theHuesped = huespedService.getHuesped(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("huesped", theHuesped);
		
		// send over to our form		
		return "huesped-form";
	}
	
	@GetMapping("/delete")
	public String deleteHuesped(@RequestParam("huespedId") int theId) {
		
		// delete the customer
		huespedService.deleteHuesped(theId);
		
		return "redirect:/huesped/list";
	}
}











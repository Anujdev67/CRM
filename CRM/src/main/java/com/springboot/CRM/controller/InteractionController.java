package com.springboot.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.CRM.exception.ResourceNotFoundException;
import com.springboot.CRM.model.Interaction;
import com.springboot.CRM.service.CustomerService;
import com.springboot.CRM.service.InteractionService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class InteractionController {
	  @Autowired
	    private InteractionService interactionService;

	    @Autowired
	    private CustomerService customerService;

	    @PostMapping
	    public Interaction addInteraction(@PathVariable int customerId, @RequestBody Interaction interaction) throws ResourceNotFoundException {
	    
	        interaction.setCustomer(customerService.getCustomerById(customerId)); //set customer
	        return interactionService.saveInteraction(interaction);
	    }

	    @GetMapping
	    public List<Interaction> getInteractionsByCustomerId(@PathVariable int customerId) {
	        return interactionService.getInteractionsByCustomerId(customerId);
	    }
}

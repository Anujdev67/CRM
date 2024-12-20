package com.springboot.CRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.CRM.exception.ResourceNotFoundException;
import com.springboot.CRM.model.Customer;
import com.springboot.CRM.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(int id) throws ResourceNotFoundException {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
	}

	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
}

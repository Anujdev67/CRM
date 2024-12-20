package com.springboot.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.CRM.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

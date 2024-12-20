package com.springboot.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.CRM.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

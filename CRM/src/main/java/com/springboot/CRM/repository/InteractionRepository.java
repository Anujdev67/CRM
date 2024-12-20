package com.springboot.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.CRM.model.Interaction;

public interface InteractionRepository extends JpaRepository<Interaction, Integer>{

}

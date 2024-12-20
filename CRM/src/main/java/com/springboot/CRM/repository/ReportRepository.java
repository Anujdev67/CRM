package com.springboot.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.CRM.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {

}

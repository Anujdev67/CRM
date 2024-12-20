package com.springboot.CRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.CRM.exception.ResourceNotFoundException;
import com.springboot.CRM.model.Report;
import com.springboot.CRM.repository.ReportRepository;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;


    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

 
    public Report getReportById(int id) throws ResourceNotFoundException {
        return reportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report not found"));
    }

  
    public void deleteReport(int id) {
        reportRepository.deleteById(id);
    }
}

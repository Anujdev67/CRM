package com.springboot.CRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.CRM.exception.ResourceNotFoundException;
import com.springboot.CRM.model.Report;
import com.springboot.CRM.service.ReportService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public Report generateReport(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable int id) throws ResourceNotFoundException {
        return reportService.getReportById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable int id) {
        reportService.deleteReport(id);
    }
}

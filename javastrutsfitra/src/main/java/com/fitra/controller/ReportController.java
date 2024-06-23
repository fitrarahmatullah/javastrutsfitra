package com.fitra.controller;

import com.fitra.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public String showReport(Model model) {
        // Get report data from service
        model.addAttribute("reportData", reportService.generateReport());
        return "report"; // Assuming you have a JSP file named 'report.jsp' to display the report
    }
}

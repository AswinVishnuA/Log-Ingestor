package com.ava.logmanager.controllers;

import com.ava.logmanager.models.LogData;
import com.ava.logmanager.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public ResponseEntity<String> ingestLog(@RequestBody LogData logData) {
        System.out.println("LogController.ingestLog");
        System.out.println("LogData "+ logData);
        try {
            logService.ingestLog(logData);
            return ResponseEntity.ok("Log ingested successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error ingesting log: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<LogData>> getLogs(
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String message,
            @RequestParam(required = false) String resourceId,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        java.sql.Date searchSqlStartDate = null;
        java.sql.Date searchSqlEndDate = null;
        if(startDate !=null){
            searchSqlStartDate = new java.sql.Date(startDate.getTime());
        }
        if(endDate !=null){
            searchSqlEndDate = new java.sql.Date(endDate.getTime());
        }
        List<LogData> logs = logService.searchLogs(level, message, resourceId,searchSqlStartDate,searchSqlEndDate);
        return ResponseEntity.ok(logs);
    }

}

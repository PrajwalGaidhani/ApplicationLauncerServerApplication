package com.prajwal.applicationlauncerserver.controller;

import com.prajwal.applicationlauncerserver.model.ApiResponse;
import com.prajwal.applicationlauncerserver.model.SystemStats;
import com.prajwal.applicationlauncerserver.service.SystemMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system")
@CrossOrigin(origins = "*")
public class SystemController {
    
    @Autowired
    private SystemMonitorService systemMonitorService;
    
    @GetMapping("/stats")
    public ResponseEntity<SystemStats> getSystemStats() {
        try {
            SystemStats stats = systemMonitorService.getSystemStats();
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/status")
    public ResponseEntity<ApiResponse> getStatus() {
        ApiResponse response = new ApiResponse(
            "success",
            "Server is running",
            System.getProperty("os.name")
        );
        return ResponseEntity.ok(response);
    }
}
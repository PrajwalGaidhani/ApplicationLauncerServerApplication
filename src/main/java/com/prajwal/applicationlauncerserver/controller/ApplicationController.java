package com.prajwal.applicationlauncerserver.controller;

import com.prajwal.applicationlauncerserver.model.ApiResponse;
import com.prajwal.applicationlauncerserver.model.LaunchRequest;
import com.prajwal.applicationlauncerserver.service.ApplicationLauncherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {
    
    @Autowired
    private ApplicationLauncherService applicationLauncherService;
    
    @PostMapping("/launch")
    public ResponseEntity<ApiResponse> launchApplication(@RequestBody LaunchRequest request) {
        boolean success = applicationLauncherService.launchApplication(request.getAppName());
        
        if (success) {
            ApiResponse response = new ApiResponse(
                "success",
                "Application launched: " + request.getAppName()
            );
            return ResponseEntity.ok(response);
        } else {
            ApiResponse response = new ApiResponse(
                "error",
                "Failed to launch: " + request.getAppName()
            );
            return ResponseEntity.status(500).body(response);
        }
    }
    
    @GetMapping("/list")
    public ResponseEntity<ApiResponse> listApplications() {
        List<String> apps = applicationLauncherService.getAvailableApplications();
        ApiResponse response = new ApiResponse(
            "success",
            "Available applications",
            apps
        );
        return ResponseEntity.ok(response);
    }
}

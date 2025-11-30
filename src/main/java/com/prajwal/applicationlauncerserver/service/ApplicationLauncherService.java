package com.prajwal.applicationlauncerserver.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ApplicationLauncherService {
    
    public boolean launchApplication(String appName) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb;
            
            if (os.contains("win")) {
                pb = new ProcessBuilder("cmd", "/c", "start", appName);
            } else if (os.contains("mac")) {
                pb = new ProcessBuilder("open", "-a", appName);
            } else {
                pb = new ProcessBuilder(appName);
            }
            
            pb.start();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<String> getAvailableApplications() {
        String os = System.getProperty("os.name").toLowerCase();
        
        if (os.contains("win")) {
            return Arrays.asList("notepad", "calc", "mspaint", "chrome");
        } else if (os.contains("mac")) {
            return Arrays.asList("Safari", "Chrome", "TextEdit", "Calculator");
        } else {
            return Arrays.asList("firefox", "gedit", "calculator");
        }
    }
}

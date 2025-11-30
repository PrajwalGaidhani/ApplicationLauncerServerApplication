package com.prajwal.applicationlauncerserver.service;

import com.prajwal.applicationlauncerserver.model.SystemStats;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.*;

@Service
public class SystemMonitorService {
    
    private final SystemInfo systemInfo = new SystemInfo();
    
    public SystemStats getSystemStats() throws InterruptedException {
        HardwareAbstractionLayer hal = systemInfo.getHardware();
        OperatingSystem os = systemInfo.getOperatingSystem();
        
        SystemStats stats = new SystemStats();
        
        // CPU Info
        stats.setCpu(getCpuInfo(hal.getProcessor()));
        
        // Memory Info
        stats.setMemory(getMemoryInfo(hal.getMemory()));
        
        // System Info
        stats.setSystem(getSystemInfo(os));
        
        // Battery Info (if available)
        if (!hal.getPowerSources().isEmpty()) {
            stats.setBattery(getBatteryInfo(hal.getPowerSources().get(0)));
        }
        
        return stats;
    }
    
    private SystemStats.CpuInfo getCpuInfo(CentralProcessor processor) throws InterruptedException {
        SystemStats.CpuInfo cpu = new SystemStats.CpuInfo();
        
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Thread.sleep(1000);
        double cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        
        cpu.setModel(processor.getProcessorIdentifier().getName());
        cpu.setCores(processor.getLogicalProcessorCount());
        cpu.setPhysicalCores(processor.getPhysicalProcessorCount());
        cpu.setUsage(Math.round(cpuLoad * 100.0) / 100.0);
        cpu.setMaxFreq(processor.getMaxFreq() / 1_000_000_000.0 + " GHz");
        
        return cpu;
    }
    
    private SystemStats.MemoryInfo getMemoryInfo(GlobalMemory memory) {
        SystemStats.MemoryInfo memInfo = new SystemStats.MemoryInfo();
        
        long totalMem = memory.getTotal();
        long availMem = memory.getAvailable();
        long usedMem = totalMem - availMem;
        
        memInfo.setTotal(formatBytes(totalMem));
        memInfo.setUsed(formatBytes(usedMem));
        memInfo.setAvailable(formatBytes(availMem));
        memInfo.setUsagePercent(Math.round((usedMem * 100.0 / totalMem) * 100.0) / 100.0);
        
        return memInfo;
    }
    
    private SystemStats.SystemInfo getSystemInfo(OperatingSystem os) {
        SystemStats.SystemInfo sysInfo = new SystemStats.SystemInfo();
        
        sysInfo.setOs(os.getFamily() + " " + os.getVersionInfo().getVersion());
        sysInfo.setUptime(formatUptime(os.getSystemUptime()));
        sysInfo.setProcesses(os.getProcessCount());
        sysInfo.setThreads(os.getThreadCount());
        
        return sysInfo;
    }
    
    private SystemStats.BatteryInfo getBatteryInfo(PowerSource battery) {
        SystemStats.BatteryInfo batteryInfo = new SystemStats.BatteryInfo();
        
        batteryInfo.setPercentage(battery.getRemainingCapacityPercent() * 100);
        batteryInfo.setCharging(battery.isCharging());
        batteryInfo.setTimeRemaining(battery.getTimeRemainingEstimated());
        
        return batteryInfo;
    }
    
    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.2f %sB", bytes / Math.pow(1024, exp), pre);
    }
    
    private String formatUptime(long seconds) {
        long days = seconds / 86400;
        long hours = (seconds % 86400) / 3600;
        long minutes = (seconds % 3600) / 60;
        return String.format("%dd %dh %dm", days, hours, minutes);
    }
}
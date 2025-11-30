
package com.prajwal.applicationlauncerserver.model;

public class SystemStats {
    private CpuInfo cpu;
    private MemoryInfo memory;
    private SystemInfo system;
    private BatteryInfo battery;
    
    // Getters and Setters
    public CpuInfo getCpu() { return cpu; }
    public void setCpu(CpuInfo cpu) { this.cpu = cpu; }
    
    public MemoryInfo getMemory() { return memory; }
    public void setMemory(MemoryInfo memory) { this.memory = memory; }
    
    public SystemInfo getSystem() { return system; }
    public void setSystem(SystemInfo system) { this.system = system; }
    
    public BatteryInfo getBattery() { return battery; }
    public void setBattery(BatteryInfo battery) { this.battery = battery; }
    
    // Inner classes for nested data
    public static class CpuInfo {
        private String model;
        private int cores;
        private int physicalCores;
        private double usage;
        private String maxFreq;
        
        // Getters and Setters
        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }
        
        public int getCores() { return cores; }
        public void setCores(int cores) { this.cores = cores; }
        
        public int getPhysicalCores() { return physicalCores; }
        public void setPhysicalCores(int physicalCores) { this.physicalCores = physicalCores; }
        
        public double getUsage() { return usage; }
        public void setUsage(double usage) { this.usage = usage; }
        
        public String getMaxFreq() { return maxFreq; }
        public void setMaxFreq(String maxFreq) { this.maxFreq = maxFreq; }
    }
    
    public static class MemoryInfo {
        private String total;
        private String used;
        private String available;
        private double usagePercent;
        
        // Getters and Setters
        public String getTotal() { return total; }
        public void setTotal(String total) { this.total = total; }
        
        public String getUsed() { return used; }
        public void setUsed(String used) { this.used = used; }
        
        public String getAvailable() { return available; }
        public void setAvailable(String available) { this.available = available; }
        
        public double getUsagePercent() { return usagePercent; }
        public void setUsagePercent(double usagePercent) { this.usagePercent = usagePercent; }
    }
    
    public static class SystemInfo {
        private String os;
        private String uptime;
        private int processes;
        private int threads;
        
        // Getters and Setters
        public String getOs() { return os; }
        public void setOs(String os) { this.os = os; }
        
        public String getUptime() { return uptime; }
        public void setUptime(String uptime) { this.uptime = uptime; }
        
        public int getProcesses() { return processes; }
        public void setProcesses(int processes) { this.processes = processes; }
        
        public int getThreads() { return threads; }
        public void setThreads(int threads) { this.threads = threads; }
    }
    
    public static class BatteryInfo {
        private double percentage;
        private boolean charging;
        private double timeRemaining;
        
        // Getters and Setters
        public double getPercentage() { return percentage; }
        public void setPercentage(double percentage) { this.percentage = percentage; }
        
        public boolean isCharging() { return charging; }
        public void setCharging(boolean charging) { this.charging = charging; }
        
        public double getTimeRemaining() { return timeRemaining; }
        public void setTimeRemaining(double timeRemaining) { this.timeRemaining = timeRemaining; }
    }
}

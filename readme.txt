================================================================================
                    PC REMOTE CONTROL SERVER
================================================================================

DESCRIPTION:
------------
A Spring Boot application that allows you to remotely control your PC from
your phone. Monitor system stats (CPU, memory, disk) and launch applications
remotely via a web interface or REST API.

REQUIREMENTS:
-------------
- Java 17 or higher
- Maven 3.6+
- Windows/Mac/Linux OS

DEPENDENCIES:
-------------
- Spring Boot 3.2.0
- Oshi 6.4.6 (System monitoring)
- Thymeleaf (Template engine)
- JSON library

QUICK START:
------------
1. Extract the project files
2. Open terminal/command prompt in project directory
3. Run: mvn clean install
4. Run: mvn spring-boot:run
5. Server will start on port 8080

ACCESSING THE APPLICATION:
--------------------------

From Laptop:
  - Home Page:    http://localhost:8080/
  - Dashboard:    http://localhost:8080/dashboard
  - API Status:   http://localhost:8080/api/system/status



FIND YOUR LAPTOP IP:
--------------------
Windows:    Run "ipconfig" in command prompt
            Look for "Wireless LAN adapter Wi-Fi" → IPv4 Address

Mac:        Run "ifconfig" in terminal
            Look for "en0" → inet address

Linux:      Run "ip addr" in terminal
            Look for "wlan0" → inet address

IMPORTANT:
----------
- Make sure laptop and phone are on the SAME WiFi network
- Allow Java through Windows Firewall (if on Windows)
- Port 8080 must be available (not used by another application)

FIREWALL SETUP (Windows):
--------------------------
1. Search "Windows Defender Firewall"
2. Click "Allow an app or feature through Windows Defender Firewall"
3. Click "Change settings"
4. Click "Allow another app"
5. Browse to your Java installation (usually C:\Program Files\Java\jdk-17\bin\java.exe)
6. Check both "Private" and "Public"
7. Click OK

API ENDPOINTS:
--------------

System Monitoring:
  GET  /api/system/stats    - Get complete system statistics
  GET  /api/system/status   - Check if server is running

Application Control:
  POST /api/applications/launch   - Launch an application
       Body: {"appName": "notepad"}
  GET  /api/applications/list     - List available applications

Web Pages:
  GET  /                    - Home page with menu
  GET  /dashboard           - Real-time system monitoring dashboard

FEATURES:
---------
✓ Real-time CPU monitoring
✓ Memory usage tracking
✓ System information (OS, uptime, processes)
✓ Launch applications remotely
✓ Battery status (for laptops)
✓ Auto-refreshing dashboard (every 5 seconds)
✓ Mobile-friendly responsive design
✓ RESTful API for custom integrations

PROJECT STRUCTURE:
------------------
src/
├── main/
│   ├── java/com/prajwal/applicationlauncherserver/
│   │   ├── ApplicationLauncherServerApplication.java  (Main class)
│   │   ├── config/         (Configuration classes)
│   │   ├── controller/     (REST API & View controllers)
│   │   ├── service/        (Business logic)
│   │   └── model/          (Data models)
│   └── resources/
│       ├── templates/      (HTML files)
│       └── application.properties

TESTING:
--------
1. Start the server
2. Open browser on laptop: http://localhost:8080/
3. You should see the home page with 4 menu items
4. Click "System Stats" to view the dashboard
5. On your phone, enter: http://YOUR_LAPTOP_IP:8080/
6. You should see the same home page

LAUNCH APPLICATIONS:
--------------------
Example apps you can launch:

Windows:
  - notepad
  - calc
  - mspaint
  - chrome

Mac:
  - Safari
  - Chrome
  - TextEdit
  - Calculator

Linux:
  - firefox
  - gedit
  - calculator

TROUBLESHOOTING:
----------------

Problem: Cannot access from phone
Solution:
  - Verify both devices on same WiFi
  - Check firewall settings
  - Confirm correct IP address
  - Try disabling firewall temporarily to test

Problem: Port 8080 already in use
Solution:
  - Change port in application.properties: server.port=8888
  - Then access at http://YOUR_IP:8888/

Problem: Application won't launch
Solution:
  - Check if application is installed
  - Try full path: "C:\\Program Files\\App\\app.exe"
  - Check application name spelling

Problem: Maven build fails
Solution:
  - Ensure Java 17+ installed: java -version
  - Clear Maven cache: mvn clean
  - Rebuild: mvn clean install

STOPPING THE SERVER:
--------------------
Press Ctrl+C in the terminal where the server is running

BUILDING JAR FILE:
------------------
To create a standalone JAR file:
1. Run: mvn clean package
2. JAR will be created in target/ folder
3. Run with: java -jar target/applicationLauncherServer-0.0.1-SNAPSHOT.jar

CUSTOMIZATION:
--------------
- Edit application.properties to change server port
- Modify HTML files in src/main/resources/templates/ for UI changes
- Add new endpoints in controller classes
- Extend SystemMonitorService for more system metrics

SECURITY NOTE:
--------------
This application is designed for LOCAL network use only. Do not expose to
the internet without proper authentication and security measures.

SUPPORT:
--------
For issues or questions, check the following:
- Ensure all dependencies are installed
- Check console logs for error messages
- Verify network connectivity
- Confirm firewall rules

VERSION:
--------
Version: 0.0.1-SNAPSHOT
Last Updated: 2025

AUTHOR:
-------
Prajwal

LICENSE:
--------
This is a personal project. Use at your own discretion.

================================================================================
                        ENJOY YOUR PC REMOTE CONTROL!
================================================================================
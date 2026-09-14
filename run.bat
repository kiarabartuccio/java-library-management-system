@echo off
where mvn >nul 2>nul
if errorlevel 1 (
    echo Maven is required. Install Maven, then run this file again.
    pause
    exit /b 1
)
mvn clean compile exec:java -Dexec.mainClass=com.mycompany.libraryoperations.LibraryManagementSystem
pause

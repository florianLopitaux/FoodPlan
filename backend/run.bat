@echo off

echo Building Spring Boot application...
call mvn clean package -DskipTests

if %errorlevel% neq 0 (
    echo Build failed
    exit /b %errorlevel%
)

echo Build successful

echo Starting backend containers...
call docker compose up -d --build
echo Backend containers successfully started

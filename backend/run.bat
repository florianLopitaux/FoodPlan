@echo off

echo Building Spring Boot application...
mvn clean package -DskipTests

if %errorlevel% neq 0 (
    echo Build failed
    exit /b %errorlevel%
)

echo Build successful

echo Starting backend containers...
docker compose up --build

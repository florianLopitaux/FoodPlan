#!/bin/bash
set -e

echo "Building Spring Boot application..."
mvn clean package -DskipTests
echo "Build successful"

echo "Starting backend containers..."
docker compose up --build

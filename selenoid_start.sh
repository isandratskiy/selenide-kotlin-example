#!/bin/bash
echo "==============================> Pulling Chrome" 
docker pull selenoid/vnc_chrome:80.0
echo "Starting Selenoid Service ... "
docker-compose up --force-recreate -d

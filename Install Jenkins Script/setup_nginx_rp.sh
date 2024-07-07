#!/bin/bash

# Install Nginx
sudo apt update
sudo apt install nginx -y

# Create a new configuration file for Jenkins
sudo cp /etc/nginx/sites-available/default /etc/nginx/sites-available/jenkins

# Edit the configuration file
sudo sed -i 's|server_name _;|server_name jenkins1.banzo.tech;|' /etc/nginx/sites-available/jenkins
sudo sed -i 's|root /var/www/html;|proxy_pass http://localhost:8080;|' /etc/nginx/sites-available/jenkins

# Create a symbolic link
sudo ln -s /etc/nginx/sites-available/jenkins /etc/nginx/sites-enabled/jenkins

# Test the configuration
sudo nginx -t

# Restart Nginx
sudo systemctl restart nginx

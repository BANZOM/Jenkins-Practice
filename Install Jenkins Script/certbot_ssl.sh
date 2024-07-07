#!/bin/bash

sudo snap install core; sudo snap refresh core
sudo snap install --classic certbot
sudo ln -s /snap/bin/certbot /usr/bin/certbot

sudo certbot --nginx -d jenkins1.banzo.tech

sudo crontab -e >> 0 0 */30 * * /usr/bin/certbot renew --quiet


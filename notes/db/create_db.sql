drop database qrapp;

create database qrapp;

grant all privileges on qrapp.* to 'qrappuser'@'127.0.0.1'
identified by 'qrappuser'
with grant option;

grant all privileges on qrapp.* to 'qrappuser'@'localhost'
identified by 'qrappuser'
with grant option;

grant all privileges on qrapp.* to 'qrappuser'@'%'
identified by 'qrappuser'
with grant option;

flush privileges;
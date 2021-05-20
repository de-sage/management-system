create user if not exists 'maintainance_user'@'localhost' identified by 'Maintainace_123';
grant all privileges on maintainace_db.* to 'maintainance_user'@'localhost';
flush privileges;


create database if not exists maintainace_db;
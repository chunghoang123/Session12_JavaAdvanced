create database rikkeicaredb;
use rikkeicaredb;

drop  table doctors;
create table doctors(
    id int primary key auto_increment,
    code varchar(20) unique not null ,
    name varchar(120) not null ,
    pass varchar(255)not null ,
    specialization varchar(100)
);


insert into doctors (code, name, pass, specialization)
values ('DOC001', 'Dr. Chung Hoang', '123456', 'Cardiology');

create database if not exists hospital;
use hospital;

create table doctors (
    doctor_id int primary key auto_increment,
    full_name varchar(100) not null,
    specialty varchar(50) not null,
    experience_years int not null,
    base_salary decimal(15,2) not null,
    password varchar(255) not null
);

insert into doctors (full_name, specialty, experience_years, base_salary, password) values
('BS. Nguyễn Văn An', 'Nội khoa', 10, 20000000, 'pass_an_123'),
('BS. Lê Thị Bình', 'Nhi khoa', 5, 15000000, 'pass_binh_456'),
('BS. Trần Quang Đạo', 'Ngoại khoa', 15, 30000000, 'pass_dao_789'),
('BS. Phạm Minh Anh', 'Nhi khoa', 3, 12000000, 'pass_anh_abc'),
('BS. Hoàng Đức Trung', 'Sản khoa', 8, 18000000, 'pass_trung_xyz');
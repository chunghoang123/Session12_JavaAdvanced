# tạo database cho dự án
create database if not exists rikkeicaredb_2;
use rikkeicaredb_2;

# tạo bảng vitals (chỉ số sinh tồn)
create table vitals (
    id int primary key auto_increment,
    patient_id int not null,
    temperature double not null,
    heart_rate int not null
);

# chèn dữ liệu mẫu ban đầu
insert into vitals (patient_id, temperature, heart_rate)
values (101, 37.0, 80);

# bai3

delimiter //
create procedure get_surgery_fee(
    in surgery_id int,
    out total_cost decimal(15,2)
)
begin
#     giả sử logic: id 1 phí 5tr, các id khác phí 2tr
    if surgery_id = 1 then
        set total_cost = 5000000.00;
    else
        set total_cost = 2000000.00;
    end if;
end //
delimiter ;

# bai4
create table lab_results (
    id int primary key auto_increment,
    patient_id int not null,
    test_value double not null,
    test_time timestamp default current_timestamp
);




# Bai5

create table inpatients (
    id int primary key auto_increment,
    patient_code varchar(20) unique,
    full_name varchar(100),
    age int,
    department varchar(50),
    admission_date date default (current_date)
);


insert into inpatients (patient_code, full_name, age, department, admission_date) values
('BN001', 'Nguyen Van A', 30, 'Noi tong hop', '2026-03-20'),
('BN002', 'Le Thi B', 25, 'Ngoai khoa', '2026-03-15'),
('BN003', 'L''Oreal Jean', 45, 'Hoi suc cap cuu', '2026-03-10'),
('BN004', 'Tran Van C', 60, 'Tim mach', current_date()),
('BN005', 'D''Arcy William', 35, 'Chan thuong chinh hinh', '2026-03-01');
-- procedure tinh vien phi (gia su 500k/ngay)
delimiter //
create procedure calculate_discharge_fee(
    in p_code varchar(20),
    out total_fee decimal(15,2)
)
begin
    declare days_stayed int;
#     tinh so ngay tu luc nhap vien den nay
    select datediff(current_date, admission_date) into days_stayed
    from inpatients where patient_code = p_code;

    if days_stayed <= 0 then set days_stayed = 1; end if;
    set total_fee = days_stayed * 500000.00;
end //
delimiter ;

# bai6
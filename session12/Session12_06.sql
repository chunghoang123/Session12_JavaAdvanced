create database rikkeicaredb_03;
use rikkeicaredb_03;

# 1. tao bang medicines (kho thuoc)
create table medicines (
    id int primary key auto_increment,
    name varchar(100) not null,
    price double not null,
    stock int not null
);

# 2. tao bang prescriptions (don thuoc)
create table prescriptions (
    id int primary key auto_increment,
    medicine_id int,
    quantity_sold int,
    sale_date date,
    foreign key (medicine_id) references medicines(id)
);

# 3. procedure tinh tong tien 1 don thuoc (OUT)
delimiter //
create procedure calculate_prescription_total(in p_id int, out p_total decimal(18,2))
begin
    select (p.quantity_sold * m.price) into p_total
    from prescriptions p
    join medicines m on p.medicine_id = m.id
    where p.id = p_id;
end //

# 4. procedure thong ke doanh thu theo ngay (IN/OUT)
create procedure get_daily_revenue(in p_date date, out p_revenue decimal(18,2))
begin
    select sum(p.quantity_sold * m.price) into p_revenue
    from prescriptions p
    join medicines m on p.medicine_id = m.id
    where p.sale_date = p_date;

#     neu ngay do khong ban duoc gi thi tra ve 0 thay vi null
    if p_revenue is null then set p_revenue = 0; end if;
end //
delimiter ;

# nap du lieu mau
insert into medicines (name, price, stock) values
('Panadol Extra', 1200.00, 1000),
('Berberin', 500.00, 2000),
('Augmentin 1g', 15000.00, 150),
('Nexium 40mg', 22000.00, 100),
('Gaviscon', 8500.00, 300),
('Efferalgan 500mg', 2500.00, 800),
('Vitamin C 500mg', 1500.00, 500);

# 3. Thêm dữ liệu vào bảng prescriptions (Đơn thuốc)
insert into prescriptions (medicine_id, quantity_sold, sale_date) values
(1, 5, '2026-03-23'),
(2, 10, '2026-03-23'),
(1, 2, curdate()),
(3, 1, curdate()),
(6, 4, curdate()),
(4, 2, '2026-03-25');
﻿--create database db_movie 

--use db_movie



-- Bảng quản lý loại nhân viên (vị trí làm việc)
CREATE TABLE EmployeeType (
    type_id INT PRIMARY KEY IDENTITY(1,1),
    position NVARCHAR(100) NOT NULL -- Vị trí làm việc (vd: Quản lý, Nhân viên bán vé, Kỹ thuật viên)
);

-- Bảng quản lý nhân viên
CREATE TABLE Employee (
    employee_id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(255) NOT NULL,
    type_id INT FOREIGN KEY REFERENCES EmployeeType(type_id), -- Liên kết với bảng EmployeeType
    hire_date NVARCHAR(10), -- Ngày bắt đầu làm việc, định dạng chuỗi (vd: 'yyyy-MM-dd')
    phone NVARCHAR(20),
    email NVARCHAR(255),
    salary FLOAT -- Lương
);

-- Bảng quản lý khách hàng
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(255) NOT NULL,
    phone NVARCHAR(20),
    email NVARCHAR(255)
);

CREATE TABLE MovieStatus (
    status_id INT PRIMARY KEY IDENTITY(1,1),
    status NVARCHAR(20) CHECK (status IN ('Đang chiếu', 'Không chiếu')) NOT NULL
);

CREATE TABLE Movie (
    movie_id INT PRIMARY KEY IDENTITY(1,1),
    title NVARCHAR(255) NOT NULL,
    genre NVARCHAR(100),
    duration INT,  -- Thời lượng phim tính bằng phút
    release_date NVARCHAR(10), -- Ngày phát hành dưới dạng chuỗi (vd: 'yyyy-MM-dd')
    director NVARCHAR(255),
    status_id INT, -- Thêm cột status_id làm khóa ngoại
    FOREIGN KEY (status_id) REFERENCES MovieStatus(status_id) -- Khóa ngoại liên kết với MovieStatus
);

-- Bảng quản lý phòng chiếu
CREATE TABLE Theater (
    theater_id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100) NOT NULL,
    location NVARCHAR(255),
    capacity INT -- Số lượng ghế
);

-- Bảng quản lý suất chiếu
CREATE TABLE Showtime (
    showtime_id INT PRIMARY KEY IDENTITY(1,1),
    movie_id INT FOREIGN KEY REFERENCES Movie(movie_id),
    theater_id INT FOREIGN KEY REFERENCES Theater(theater_id),
    show_date NVARCHAR(10), -- Ngày chiếu dưới dạng chuỗi (vd: 'yyyy-MM-dd')
    start_time NVARCHAR(5) -- Thời gian bắt đầu dưới dạng chuỗi (vd: 'HH:mm')
);

-- Bảng quản lý vé
CREATE TABLE Ticket (
    ticket_id INT PRIMARY KEY IDENTITY(1,1),
    showtime_id INT FOREIGN KEY REFERENCES Showtime(showtime_id),
    seat_number NVARCHAR(10),
    price FLOAT, -- Giá vé
    purchase_time NVARCHAR(255) -- Thời gian mua vé dưới dạng chuỗi
);

-- Bảng quản lý hóa đơn
CREATE TABLE Invoice (
    invoice_id INT PRIMARY KEY IDENTITY(1,1),
    customer_name NVARCHAR(255), -- Tên khách hàng nếu không có tài khoản
    customer_id INT FOREIGN KEY REFERENCES Customer(customer_id), -- Liên kết với bảng khách hàng (nếu có)
    total_amount FLOAT, -- Tổng tiền thanh toán
    purchase_time NVARCHAR(19) DEFAULT CONVERT(NVARCHAR, GETDATE(), 120), -- Thời gian thanh toán
    employee_id INT FOREIGN KEY REFERENCES Employee(employee_id), -- Nhân viên thực hiện giao dịch
	ticket_id INT FOREIGN KEY REFERENCES Ticket(ticket_id) -- Liên kết với bảng vé
);

CREATE TABLE InvoiceDetail (
    invoice_id INT, -- Liên kết với bảng hóa đơn
    ticket_id INT, -- Liên kết với bảng vé
    quantity INT, -- Số lượng vé
    price_per_ticket FLOAT, -- Giá vé đơn lẻ
    PRIMARY KEY (invoice_id, ticket_id), -- Khóa chính là cặp invoice_id và ticket_id
    FOREIGN KEY (invoice_id) REFERENCES Invoice(invoice_id),
    FOREIGN KEY (ticket_id) REFERENCES Ticket(ticket_id)
);



-- bảng Loại ghế
CREATE TABLE SeatType (
    seat_type_id INT PRIMARY KEY IDENTITY(1,1),
    type_name VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- bảng Ghế
CREATE TABLE Seat (
    seat_id INT PRIMARY KEY IDENTITY(1,1),
    showtime_id INT,
    seat_number VARCHAR(10) NOT NULL,
    seat_type_id INT,
    status NVARCHAR(20) CHECK (status IN ('Còn chỗ', 'Hết chỗ')) NOT NULL,
    FOREIGN KEY (showtime_id) REFERENCES Showtime(showtime_id),
    FOREIGN KEY (seat_type_id) REFERENCES SeatType(seat_type_id)
);



INSERT INTO EmployeeType (position) VALUES 
(N'Quản lý'),
(N'Nhân viên bán vé'),
(N'Kỹ thuật viên');

INSERT INTO Employee (name, type_id, hire_date, phone, email) VALUES 
(N'Nguyễn Văn A', 1, N'2022-01-10', N'0901234567', N'a.nguyen@example.com'),
(N'Tran Thị B', 2, N'2023-03-20', N'0902345678', N'b.tran@example.com'),
(N'Lê Văn C', 3, N'2021-06-15', N'0903456789', N'c.le@example.com');

-- Thêm trạng thái vào bảng MovieStatus
INSERT INTO MovieStatus (status)
VALUES ('Đang chiếu'), ('Không chiếu');

INSERT INTO Movie (title, genre, duration, release_date, director, status_id) VALUES
('Inception', 'Khoa học viễn tưởng', 148, '2010-07-16', 'Christopher Nolan', 1),  -- 1 là 'Đang chiếu'
('The Dark Knight', 'Hành động', 152, '2008-07-18', 'Christopher Nolan', 2),     -- 2 là 'Không chiếu'
('Titanic', 'Lãng mạn', 195, '1997-12-19', 'James Cameron', 1),
('Avatar', 'Khoa học viễn tưởng', 162, '2009-12-18', 'James Cameron', 1),
('Parasite', 'Kinh dị', 132, '2019-05-30', 'Bong Joon-ho', 2),
('Avengers: Endgame', 'Hành động', 181, '2019-04-26', 'Anthony Russo, Joe Russo', 1),
('The Matrix', 'Khoa học viễn tưởng', 136, '1999-03-31', 'Lana Wachowski, Lilly Wachowski', 2),
('Forrest Gump', 'Tâm lý', 142, '1994-07-06', 'Robert Zemeckis', 1),
('Interstellar', 'Khoa học viễn tưởng', 169, '2014-11-07', 'Christopher Nolan', 1),
('The Godfather', 'Tội phạm', 175, '1972-03-24', 'Francis Ford Coppola', 2);


--INSERT INTO Customer (name, phone, email) VALUES 
--(N'Phan Thị D', N'0904567890', N'd.phan@example.com'),
--(N'Hoàng Văn E', N'0905678901', N'e.hoang@example.com');


--INSERT INTO Theater (name, location, capacity) VALUES 
--(N'Phòng 1', N'Tầng 1', 100),
--(N'Phòng 2', N'Tầng 2', 150),
--(N'Phòng VIP', N'Tầng 3', 50);

--INSERT INTO Showtime (movie_id, theater_id, show_date, start_time) VALUES 
--(1, 1, N'2024-09-10', N'14:00'), -- The Matrix
--(2, 2, N'2024-09-11', N'16:30'), -- Inception
--(3, 3, N'2024-09-12', N'18:00'); -- Titanic

--INSERT INTO Ticket (showtime_id, seat_number, price, purchase_time) VALUES 
--(1, N'A1', 7.5, N'2024-09-05 13:45:00'),
--(2, N'B2', 9.0, N'2024-09-05 15:00:00'),
--(3, N'C3', 12.5, N'2024-09-05 17:30:00');

--INSERT INTO Invoice (customer_name, customer_id, total_amount, purchase_time, employee_id, ticket_id) VALUES 
--(N'Phan Thị D', 1, 7.5, N'2024-09-05 13:50:00', 2, 1),  -- Liên kết với vé có ticket_id = 1
--(N'Hoàng Văn E', 2, 9.0, N'2024-09-05 15:05:00', 2, 2),  -- Liên kết với vé có ticket_id = 2
--(N'Nguyễn Văn F', NULL, 12.5, N'2024-09-05 17:35:00', 1, 3); -- Liên kết với vé có ticket_id = 3

ALTER TABLE Customer
DROP COLUMN email;

ALTER TABLE Employee
DROP COLUMN salary;

--drop database db_movie

select * from Movie m
inner join MovieStatus ms on m.status_id = ms.status_id where m.status_id = 1
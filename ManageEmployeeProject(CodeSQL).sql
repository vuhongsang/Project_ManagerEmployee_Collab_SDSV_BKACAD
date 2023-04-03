drop database sdsv;
create database sdsv;
use sdsv;
create table Departments(
dept_id int primary key auto_increment,
dept_name varchar(255) not null,
dept_address varchar(255) not null,
dept_phone int (255) not null,
dept_task varchar(255) not null,
dept_manager int default 0
);
create table Finances(
fin_id int primary key auto_increment,
fin_name varchar(255) unique not null,
salary_rage decimal default 0,
insurance decimal default 0,
annual decimal default 0
);
create table Employees(
emp_id int primary key auto_increment,
first_name varchar(255) not null,
last_name varchar(255) not null,
position varchar(255) not null,
birth_of_date varchar(255) not null,
gender tinyint(1) not null,
email varchar(255) unique not null,
phone int unique not null,
hire_date varchar(255) not null,
end_date varchar(255) not null,
fin_id int,
CONSTRAINT FK_emp_per FOREIGN KEY (fin_id) REFERENCES Finances(fin_id),
dept_id int,
CONSTRAINT FK_emp_dept FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);
create table Leaves(
lev_id int primary key auto_increment,
lev_reason varchar(255) not null,
lev_start_date varchar(255) not null,
lev_end_date varchar(255) not null,
emp_id int not null,
CONSTRAINT FK_emp_lev FOREIGN KEY (emp_id) REFERENCES Employees(emp_id)
);

create table Accounts(
ac_id int primary key auto_increment,
user_name varchar(255) unique not null,
user_pass varchar(255) not null,
account_level int default 0
);

INSERT INTO `sdsv`.`departments` (`dept_name`, `dept_address`, `dept_phone`, `dept_task`,`dept_manager`) VALUES ('IT dept', 'Floor a', '1351', 'manage database','1');
INSERT INTO `sdsv`.`departments` (`dept_name`, `dept_address`, `dept_phone`, `dept_task`,`dept_manager`) VALUES ('HR dept', 'Floor b', '1353', 'manage human ','2');
INSERT INTO `sdsv`.`departments` (`dept_name`, `dept_address`, `dept_phone`, `dept_task`,`dept_manager`) VALUES ('Sales dept', 'Floor c', '1355', 'sale and customer service','1');
INSERT INTO `sdsv`.`departments` (`dept_name`, `dept_address`, `dept_phone`, `dept_task`,`dept_manager`) VALUES ('Logistic dept', 'Floor d', '1357', 'delivery','3');
INSERT INTO `sdsv`.`departments` (`dept_name`, `dept_address`, `dept_phone`, `dept_task`,`dept_manager`) VALUES ('Purchasing dept', 'Floor e', '1359', 'cost and price','5');
INSERT INTO `sdsv`.`departments` (`dept_name`, `dept_address`, `dept_phone`, `dept_task`,`dept_manager`) VALUES ('Financial dept', 'Floor f', '1380', 'accounting tax','2');
INSERT INTO `sdsv`.`departments` (`dept_name`, `dept_address`, `dept_phone`, `dept_task`,`dept_manager`) VALUES ('Audit dept', 'floor g', '1382', 'audit and patrol','4');
INSERT INTO `sdsv`.`departments` (`dept_name`, `dept_address`, `dept_phone`, `dept_task`,`dept_manager`) VALUES ('Product dept', 'floor h', '1388', 'product ','7');

INSERT INTO `sdsv`.`finances` (`fin_name`, `salary_rage`, `insurance`, `annual`) VALUES ('G1', '5000000', '8', '500000');
INSERT INTO `sdsv`.`finances` (`fin_name`, `salary_rage`, `insurance`, `annual`) VALUES ('G2', '10000000', '8', '8000000');
INSERT INTO `sdsv`.`finances` (`fin_name`, `salary_rage`, `insurance`, `annual`) VALUES ('G3', '30000000', '13', '15000000');
INSERT INTO `sdsv`.`finances` (`fin_name`, `salary_rage`, `insurance`, `annual`) VALUES ('G4', '50000000', '13', '30000000');
INSERT INTO `sdsv`.`finances` (`fin_name`, `salary_rage`, `insurance`, `annual`) VALUES ('G5', '90000000', '15', '50000000');

INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('VU', 'MINH', 'Staff', '09/11/1989', '1', 'minhtu@gmail.com', '039113000', '15/2/2022', '19/4/2023', '4', '1');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('TRAN', 'LINH', 'Staff', '09/02/1991', '0', 'tranlinh@gmail.com', '039113002', '27/5/2021', '23/7/2024', '2', '2');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('NGUYEN', 'NHI', 'Staff', '01/03/2001', '0', 'nguyennhi@gmail.com', '039113256', '3/6/2021', '12/1/2023', '1', '1');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('LY', 'QUOC', 'Staff', '26/1/2000', '1', 'lyquoc@gmail.com', '039968606', '15/11/2024', '18/2/2024', '1', '3');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('LUONG', 'VAN', 'Staff', '4/11/1990', '0', 'luongvan@gmail.com', '035603304', '26/4/2020', '9/3/2024', '3', '5');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('KIM', 'LY', 'Staff', '11/10/1996', '0', 'kimly@gmail.com', '036155153', '26/8/2024', '4/4/2025', '4', '6');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('TRUONG', 'KHANH', 'Staff', '27/6/1993', '1', 'truongkhanh@gmail.com', '035222999', '09/11/2022', '02/03/2025', '2', '8');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('TRAN', 'DAO', 'Staff', '27/8/1996', '0', 'trandao@gmail.com', '035135565', '27/3/2024', '24/11/2025', '5', '4');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('TRAN', 'NGAN', 'Staff', '27/8/1996', '0', 'tranngan@gmail.com', '035235333', '27/3/2024', '24/11/2025', '4', '4');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('NGUYEN', 'HUY', 'Staff', '20/1//1992', '1', 'nguyenhuy@gmail.com', '035699156', '3/6/2021', '12/1/2023', '5', '7');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('VU', 'NHUNG', 'Staff', '1/7/2003', '0', 'vunhung@gmail.com', '041235368', '27/5/2021', '4/4/2025', '1', '7');
INSERT INTO `sdsv`.`employees` (`first_name`, `last_name`, `position`, `birth_of_date`, `gender`, `email`, `phone`, `hire_date`, `end_date`, `fin_id`, `dept_id`) VALUES ('BA', 'HUYEN', 'Staff', '20/11/2001', '0', 'bahuyen@gmail.com', '035945582', '15/2/2022', '4/4/2025', '1', '3');

INSERT INTO `sdsv`.`leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('Sick', '01/01/2023', '02/01/2023', '1');
INSERT INTO `sdsv`.`leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('Sick', '01/02/2023', '05/02/2023', '3');
INSERT INTO `sdsv`.`leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('Private', '05/06/2023', '04/06/2023', '5');
INSERT INTO `sdsv`.`leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('Go home', '15/02/2023', '18/03/2023', '1');
INSERT INTO `sdsv`.`leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('Wedding', '19/05/2023', '22/05/2023', '2');
INSERT INTO `sdsv`.`leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('Wedding', '01/01/2023', '03/01/2023', '4');
INSERT INTO `sdsv`.`leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('Go home', '30/04/2023', '19/08/2023', '6');
INSERT INTO `sdsv`.`leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('Go home', '09/08/2023', '01/05/2023', '9');

INSERT INTO `sdsv`.`accounts` (`user_name`, `user_pass`, `account_level`) VALUES ('admin', 'Admin@2023', '1');
INSERT INTO `sdsv`.`accounts` (`user_name`, `user_pass`) VALUES ('User', 'User1@2023');



create database bankmanagementsystem;

show databases;

use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), address varchar(40), city varchar(25), pin varchar(20), state varchar(25));

show tables;

select * from signup;


create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20), aadhar varchar(20), senior_citizen varchar(20), existing_account varchar(20));

show tables;

select * from  signup;

Create table signupthree(formno varchar(20), accounttype varchar(30), cardnumber varchar(25), pin varchar(10),  facility varchar(100));

select * from  signupthree;

create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));

Select * from login;

ALTER TABLE bank MODIFY type varchar(16000); -- Adjust the length as needed


select * from  signupthree;

create table bank(pin varchar(20), date varchar(50), type varchar(100), amount varchar(50));

select * from bank;

drop table login;

create table bank_details(pin varchar(10), date datetime(2), type varchar(20), amount varchar(20));

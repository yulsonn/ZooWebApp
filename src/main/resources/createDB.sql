create USER zoomanager@localhost identified by '123123';
grant usage on *.* to zoomanager@localhost identified by '123123';
create database if not exists zoodb;
grant all privileges on zoodb.* to zoomanager@localhost;
use zoodb;
create table animal
(
	  id				    int primary key auto_increment,
    name			    varchar(55),
    type			    varchar(30),
    age				    int,
    cage_id			  int,
    caretaker_id 	int
);

create table cage
(
	  id				    int primary key auto_increment,
    number			  int,
    description		varchar(255)
);

create table caretaker
(
	  id				    int primary key auto_increment,
    first_name		varchar(55),
    last_name		  varchar(55)
)


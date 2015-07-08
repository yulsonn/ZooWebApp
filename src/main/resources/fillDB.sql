use zoodb;

insert into cage (number, description) values(1,'Animal cage 1');
insert into cage (number, description) values(2,'Animal cage 2');
insert into cage (number, description) values(3,'Animal cage 3');
insert into cage (number, description) values(12,'Animal cage 12');

insert into caretaker (first_name, last_name) values('Ivan', 'Ivanov');
insert into caretaker (first_name, last_name) values('Petr', 'Petrov');
insert into caretaker (first_name, last_name) values('Andrey', 'Andreev');
insert into caretaker (first_name, last_name) values('Fedor', 'Fedorov');

insert into animal (name, type, age, cage_id, caretaker_id) values('Max', 'Tiger', 3, 1, 1);
insert into animal (name, type, age, cage_id, caretaker_id) values('Leo', 'Lion', 5, 2, 1);
insert into animal (name, type, age, cage_id, caretaker_id) values('Balu', 'Bear', 10, 3, 2);
insert into animal (name, type, age, cage_id, caretaker_id) values('Jack', 'Koala', 2, 4, 3);
insert into animal (name, type, age, cage_id, caretaker_id) values('Umka', 'Bear', 1, 3, 4);
insert into animal (name, type, age, cage_id, caretaker_id) values('MadMax', 'Tiger', 2, 1, 3);
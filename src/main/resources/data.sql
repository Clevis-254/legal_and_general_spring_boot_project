USE group_5_client_project;
delete from users;
insert into users (username, password, email)
values
    ('adminJerry', 'adminPassword', 'group5superuser@gmail.com'),

    ('userHoward', 'userPassword', 'group5employeetest@gmail.com');
delete from adminusers;

insert into adminusers (userID) values (1);
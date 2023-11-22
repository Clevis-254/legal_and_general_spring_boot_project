USE group_5_client_project;

insert into users (username, password, email)
values
    ('adminJerry', 'adminPassword', 'group5superuser@gmail.com'),

    ('userHoward', 'userPassword', 'group5employeetest@gmail.com');

insert into adminusers (userID) values (1);
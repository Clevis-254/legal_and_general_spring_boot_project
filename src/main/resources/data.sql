USE group_5_client_project;
delete from users;
insert into users (username, password, email)
values
    ('adminJerry', 'adminPassword', 'group5superuser@gmail.com'),

    ('userHoward', '$2a$12$rBEd347g7M7hOj400ALV/.QkYK1BLlUQlU1faCu.9oKWAwEzBfRzi', 'group5employeetest@gmail.com');
delete from adminusers;

insert into adminusers (userID) values (1);
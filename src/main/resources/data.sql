USE group_5_client_project;
delete from users;
insert into users (name, password, username, enabled, role)
values
    ('adminJerry', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'group5superuser@gmail.com',true,'ROLE_ADMIN'),

    ('userHoward', '$2a$12$9smU000YcKQckNGLnkc9Cunkmc7uYEFqEY.TUYOLQ5Fic1LgPlGhy', 'group5employeetest@gmail.com', true,'ROLE_USER');

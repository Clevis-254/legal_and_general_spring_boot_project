USE group_5_client_project;

insert into users (name, password, username, enabled, role)
values
    ('adminJerry', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'group5superuser@gmail.com',true, 'ROLE_ADMIN'),

    ('adminTom', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'notareal@gmail.com',true, 'ROLE_ADMIN'),

    ('Bobby', '$2a$12$OvwO5ZSuDshVe7C/igPr3O6YXPqL/wc8T8K3gcAWsgxX0BWOvRp2e', 'emailing.tester345@gmail.com', true, 'ROLE_USER'),

    ('userHoward', '$2a$12$9smU000YcKQckNGLnkc9Cunkmc7uYEFqEY.TUYOLQ5Fic1LgPlGhy', 'group5employeetest@gmail.com', true, 'ROLE_USER');

insert into questions (question_text, date_added, category)
values
    ('Building meaningful relationships across teams and projects.', curdate(), 'collaborative'),
    ('Sharing your experiences openly so that people can learn. ', curdate(), 'collaborative'),
    ('Actively seeking out opportunities to support others in their work.', curdate(), 'collaborative'),
    ('As being open and approachable', curdate(), 'collaborative');




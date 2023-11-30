USE group_5_client_project;
delete from users;
insert into users (name, password, username, enabled)
values
    ('adminJerry', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'group5superuser@gmail.com',true),



    ('userHoward', '$2a$12$9smU000YcKQckNGLnkc9Cunkmc7uYEFqEY.TUYOLQ5Fic1LgPlGhy', 'group5employeetest@gmail.com', true);

insert into questions (question_text, date_added, category)
values
    ('Building meaningful relationships across teams and projects.', curdate(), 'collaborative'),
    ('Sharing your experiences openly so that people can learn. ', curdate(), 'collaborative'),
    ('Actively seeking out opportunities to support others in their work.', curdate(), 'collaborative'),
    ('As being open and approachable', curdate(), 'collaborative');
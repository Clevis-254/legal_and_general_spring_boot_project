USE group_5_client_project;

insert into users (firstname,secondname, password, username, enabled, role)
values
    ('admin','Jerry', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'group5superuser@gmail.com',true, 'ROLE_ADMIN'),


    ('user','Howard', '$2a$12$9smU000YcKQckNGLnkc9Cunkmc7uYEFqEY.TUYOLQ5Fic1LgPlGhy', 'group5employeetest@gmail.com', true, 'ROLE_USER'),

    ('admin','Tom', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'notareal@gmail.com',true, 'ROLE_ADMIN'),

    ('Bobby', 'james','$2a$12$OvwO5ZSuDshVe7C/igPr3O6YXPqL/wc8T8K3gcAWsgxX0BWOvRp2e', 'emailing.tester345@gmail.com', true, 'ROLE_USER');




insert into questions (question_text, date_added, category)
values
    ('Building meaningful relationships across teams and projects.', curdate(), 'collaborative'),
    ('Sharing your experiences openly so that people can learn. ', curdate(), 'collaborative'),
    ('Actively seeking out opportunities to support others in their work.', curdate(), 'collaborative'),
    ('As being open and approachable', curdate(), 'collaborative');

insert into results (userid, date_added, current_status) values
    (1, curdate(), 'pending'),
    (2, curdate(), 'pending');


insert into requests (userID, firstname,secondname, requested )
values
('1', 'admin','Jerry', curdate()),
('2', 'user','Howard', curdate());

INSERT INTO contact_questions (question, category) VALUES
                                               ('Building meaningful relationships across teams and projects.', 'Collaborative'),
                                               ('Sharing your experiences openly so that people can learn.', 'Collaborative'),
                                               ('Actively seeking out opportunities to support others in work.', 'Collaborative'),
                                               ('Being open and approachable.', 'Collaborative');

-- Insert questions for the second category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Experimenting to learn what works and pivoting when it doesn''t.', 'Purposeful'),
                                               ('Accepting and building on others'' ideas and opinions to achieve the best possible outcome.', 'Purposeful'),
                                               ('Working for the good of the collective rather than your own priorities.', 'Purposeful'),
                                               ('Promoting and discussing how our purpose connects to the greater customer outcomes.', 'Purposeful');

-- Insert questions for the third category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Actively asking for feedback and receiving it with curiosity.', 'Straight-Forward'),
                                               ('Listening openly to really understand.', 'Straight-Forward'),
                                               ('Taking the time to get to know others.', 'Straight-Forward'),
                                               ('Having the courage to challenge constructively and respectfully.', 'Straight-Forward');

-- Insert questions for the fourth category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Demonstrating high levels of self-awareness.', 'Authentic'),
                                               ('Creating an environment of trust where you trust others and earn others'' trust in return.', 'Authentic'),
                                               ('Empowering others to get on with their work and helping clear obstacles out of the way.', 'Authentic'),
                                               ('Behaving consistently across different situations.', 'Authentic');

-- Insert questions for the fifth category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Ruthlessly prioritizing and communicating it clearly.', 'Agile'),
                                               ('Talking openly about your mistakes to help others learn.', 'Agile'),
                                               ('Creating a climate where people feel safe and are encouraged to speak up.', 'Agile'),
                                               ('Anticipating and responding to change at pace.', 'Agile'),
                                               ('Driving commercial value that focuses on our customers and shareholders.', 'Agile');

-- Insert questions for the sixth category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Driving enterprise-wide success.', 'Ambitious'),
                                               ('Driving outcomes that start with our customers.', 'Ambitious'),
                                               ('Pushing boundaries to create opportunities for future success.', 'Ambitious'),
                                               ('Thinking about the future and changes that are needed.', 'Ambitious');

insert into contact_questions (question, category) VALUEs('What do you consider to be your superpower? :', 'textarea');
insert into contact_questions (question, category) VALUEs('What is the one thing you could do to improve your impact? :', 'textarea');



-- insert into contacts (id, fname, surname, email, category, reviewsId ) values
--    (1, 'Jerry', 'Garcia', 'email@domain.com', 'manager', 2),
--    (2, 'Howard', 'Hughes', 'email@domain.com', 'peer', 2);



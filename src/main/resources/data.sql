USE group_5_client_project;

insert into users (name, password, username, enabled, role)
values
    ('adminJerry', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'group5superuser@gmail.com',true, 'ROLE_ADMIN'),

    ('userHoward', '$2a$12$9smU000YcKQckNGLnkc9Cunkmc7uYEFqEY.TUYOLQ5Fic1LgPlGhy', 'group5employeetest@gmail.com', true, 'ROLE_USER');

insert into questions (question_text, date_added, category)
values
    ('Building meaningful relationships across teams and projects.', curdate(), 'collaborative'),
    ('Sharing your experiences openly so that people can learn. ', curdate(), 'collaborative'),
    ('Actively seeking out opportunities to support others in their work.', curdate(), 'collaborative'),
    ('As being open and approachable', curdate(), 'collaborative');

insert into requests (userID, name, requested )
values
('1', 'adminJerry', curdate()),
('2', 'userHoward', curdate());

INSERT INTO contact_questions (question, category) VALUES
                                               ('Building meaningful relationships across teams and projects.', 'Collaborative'),
                                               ('Sharing your experiences openly so that people can learn.', 'Collaborative'),
                                               ('Actively seeking out opportunities to support others in work.', 'Collaborative'),
                                               ('Being open and approachable.', 'Collaborative');

-- Insert questions for the second category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Experimenting to learn what works and pivoting when it doesn''t.', 'SecondCategory'),
                                               ('Accepting and building on others'' ideas and opinions to achieve the best possible outcome.', 'SecondCategory'),
                                               ('Working for the good of the collective rather than your own priorities.', 'SecondCategory'),
                                               ('Promoting and discussing how our purpose connects to the greater customer outcomes.', 'SecondCategory');

-- Insert questions for the third category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Actively asking for feedback and receiving it with curiosity.', 'ThirdCategory'),
                                               ('Listening openly to really understand.', 'ThirdCategory'),
                                               ('Taking the time to get to know others.', 'ThirdCategory'),
                                               ('Having the courage to challenge constructively and respectfully.', 'ThirdCategory');

-- Insert questions for the fourth category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Demonstrating high levels of self-awareness.', 'FourthCategory'),
                                               ('Creating an environment of trust where you trust others and earn others'' trust in return.', 'FourthCategory'),
                                               ('Empowering others to get on with their work and helping clear obstacles out of the way.', 'FourthCategory'),
                                               ('Behaving consistently across different situations.', 'FourthCategory');

-- Insert questions for the fifth category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Ruthlessly prioritizing and communicating it clearly.', 'FifthCategory'),
                                               ('Talking openly about your mistakes to help others learn.', 'FifthCategory'),
                                               ('Creating a climate where people feel safe and are encouraged to speak up.', 'FifthCategory'),
                                               ('Anticipating and responding to change at pace.', 'FifthCategory'),
                                               ('Driving commercial value that focuses on our customers and shareholders.', 'FifthCategory');

-- Insert questions for the sixth category
INSERT INTO contact_questions (question, category) VALUES
                                               ('Driving enterprise-wide success.', 'SixthCategory'),
                                               ('Driving outcomes that start with our customers.', 'SixthCategory'),
                                               ('Pushing boundaries to create opportunities for future success.', 'SixthCategory'),
                                               ('Thinking about the future and changes that are needed.', 'SixthCategory');

insert into contact_questions (question, category) VALUEs('What do you consider to be your superpower? :', 'textarea');
insert into contact_questions (question, category) VALUEs('What is the one thing you could do to improve your impact? :', 'textarea');




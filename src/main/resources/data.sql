USE group_5_client_project;

insert into users (firstname,secondname, password, username, enabled, role)
values
    ('admin','Jerry', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'group5superuser@gmail.com',true, 'ROLE_ADMIN'),


    ('user','Howard', '$2a$12$9smU000YcKQckNGLnkc9Cunkmc7uYEFqEY.TUYOLQ5Fic1LgPlGhy', 'group5employeetest@gmail.com', true, 'ROLE_USER'),

    ('admin','Tom', '$2a$12$wDcq7K1Hu/PPFD2CPKeMpeZLWuv73domPxX3EcHjwmHs8.ljiej9G', 'notareal@gmail.com',true, 'ROLE_ADMIN'),

    ('Bobby', 'james','$2a$12$OvwO5ZSuDshVe7C/igPr3O6YXPqL/wc8T8K3gcAWsgxX0BWOvRp2e', 'emailing.tester345@gmail.com', true, 'ROLE_USER');





insert into results (userid, date_added, current_status) values
                                                             (1, curdate(), 'pending'),
                                                             (2, curdate(), 'pending');


insert into requests (userID, firstname,secondname, requested )
values
    ('1', 'admin','Jerry', curdate()),
    ('2', 'user','Howard', curdate());

INSERT INTO questions (question_num, question_user_text, question_contact_text, date_added, category) VALUES
                                                                                                          ('1','Building meaningful relationships across teams and projects.', 'Building meaningful relationships across teams and projects.', NOW(), 'Collaborative'),
                                                                                                          ('2','Sharing your experiences openly so that people can learn. ', 'Sharing their experiences openly so that people can learn.', NOW(), 'Collaborative'),
                                                                                                          ('3','Actively seeking out opportunities to support others in their work.', 'Actively seeking out opportunities to support you and others in work.', NOW(), 'Collaborative'),
                                                                                                          ('4','As being open and approachable', 'As being open and approachable.', NOW(), 'Collaborative');

-- Insert questions for the second category
INSERT INTO questions (question_num, question_user_text,question_contact_text, date_added, category) VALUES
                                                                                                         ('5','Experimenting to learn what works and pivoting when it doesn''t.','Experimenting to learn what works and pivoting when it doesn''t.', NOW(), 'Purposeful'),
                                                                                                         ('6','Accepting and building on others'' ideas and opinions to achieve the best possible outcome.','Accepting and building on others'' ideas and opinions to achieve the best possible outcome.', NOW(), 'Purposeful'),
                                                                                                         ('7','Working for the good of the collective rather than your own priorities.','Working for the good of the collective rather than individual priorities.', NOW(), 'Purposeful'),
                                                                                                         ('8','Promoting and discussing how our purpose connects to the greater customer outcomes.','Promoting and discussing how our purpose connects to the greater customer outcomes.', NOW(), 'Purposeful');

-- Insert questions for the third category
INSERT INTO questions (question_num, question_user_text,question_contact_text, date_added, category) VALUES
                                                                                                         ('9','Actively asking for feedback and receiving it with curiosity.','Actively asking for feedback and receiving it with curiosity.', NOW(), 'Straight-Forward'),
                                                                                                         ('10','Listening openly to really understand.','Listening openly to really understand.', NOW(), 'Straight-Forward'),
                                                                                                         ('11','Taking the time to get to know others.','Taking the time to get to know others.', NOW(), 'Straight-Forward'),
                                                                                                         ('12','Having the courage to challenge constructively and respectfully.','Having the courage to challenge constructively and respectfully.', NOW(), 'Straight-Forward');

-- Insert questions for the fourth category
INSERT INTO questions (question_num, question_user_text,question_contact_text, date_added, category) VALUES
                                                                                                         ('12','Demonstrating high levels of self-awareness.','Demonstrating high levels of self-awareness.',NOW(), 'Authentic'),
                                                                                                         ('13','Creating an environment of trust where you trust others and earn others'' trust in return.','Creating an environment of trust where they trust others and earn their trust in return.', NOW(), 'Authentic'),
                                                                                                         ('14','Empowering others to get on with their work and helping clear obstacles out of the way.','Empowering others to get on with their work and helping clear obstacles out of their way.', NOW(), 'Authentic'),
                                                                                                         ('15','Behaving consistently across different situations.','Behaving consistently across different situations.', NOW(), 'Authentic');

-- Insert questions for the fifth category
INSERT INTO questions (question_num, question_user_text,question_contact_text, date_added, category) VALUES
                                                                                                         ('16','Ruthlessly prioritizing and communicating it clearly.','Ruthlessly prioritizing and communicating it clearly.', NOW(), 'Agile'),
                                                                                                         ('17','Talking openly about your mistakes to help others learn.','Talking openly about their mistakes to help others learn.', NOW(), 'Agile'),
                                                                                                         ('18','Creating a climate where people feel safe and are encouraged to speak up.','Creating a climate where people feel safe and are encouraged to speak up.', NOW(), 'Agile'),
                                                                                                         ('19','Anticipating and responding to change at pace.','Anticipating and responding to change at pace.', NOW(), 'Agile'),
                                                                                                         ('20','Driving commercial value that focuses on our customers and shareholders.','Driving commercial value that focuses on our customers and shareholders.', NOW(), 'Agile');

-- Insert questions for the sixth category
INSERT INTO questions (question_num, question_user_text,question_contact_text, date_added, category) VALUES
                                                                                                         ('21','Driving enterprise-wide success.','Driving enterprise-wide success', NOW(), 'Ambitious'),
                                                                                                         ('22','Driving outcomes that start with our customers.','Driving outcomes that start with our customers', NOW(), 'Ambitious'),
                                                                                                         ('23','Pushing boundaries to create opportunities for future success.','Pushing Boundaries to create opportunities for future success', NOW(), 'Ambitious'),
                                                                                                         ('24','Thinking about the future and changes that are needed.','Thinking about the future and changes that are needed', NOW(), 'Ambitious');

insert into questions (question_num, question_user_text,question_contact_text, date_added, category) VALUEs('25','What do you consider to be your superpower? :','What do you consider to be this person''s superpower? :', NOW(), 'textarea');
insert into questions (question_num, question_user_text,question_contact_text, date_added, category) VALUEs('26','What is the one thing you could do to improve your impact? :','What is the one thing this person could do to improve their  impact? :', NOW(), 'textarea');






# insert into contacts (id, fname, surname, email, category, reviewsId ) values
#    (1, 'Jerry', 'Garcia', 'email@domain.com', 'manager', 1),
#    (2, 'Howard', 'Hughes', 'email@domain.com', 'peer', 1);
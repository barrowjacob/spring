USE springblog_db;

INSERT INTO sandiwches(sandwich_name, who_owns_the_sandwich)
VALUES ('the big cheese', 'james'),
       ('margherita pizza sandwich', 'drunkard'),
       ('ham','plain jane'),
       ('chicken fried steak sandwich', 'a very nice person');

INSERT INTO sandwich_details(history_of_sandwich, ingredients, is_delicious, sandwich_id) VALUES ('cheese will never die', 'cheese', 1, 1),
               ('nobody knows where this came from', 'like an italian sauce or something',0,2),
               ('invented when the pig was first killed', 'piggies',1,3),
                                                                                                 ('this isn\'t a real sandwich', 'happiness, probably chicken fried steak', 1, 4);
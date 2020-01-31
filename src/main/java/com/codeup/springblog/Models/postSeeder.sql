use springblog_db;
DROP database springblog_db;
TRUNCATE post_details;
TRUNCATE posts;
TRUNCATE post_images;
INSERT INTO posts(body, title, user_id)
VALUES ( 'there once was a cat', 'cat1', 1),
    ( 'that cat was not very nice', 'cat2',1),
       ('neither was this cat','cat3',1);

INSERT INTO post_details(history_of_post, is_awesome, topic_description, post_id) VALUES ('history of post1', 1, 'a description of topic 1', 1),
 ('history of post2',0,'a description of topic2',2),
 ('history of post 3', 1,'a description of topic3', 3);

INSERT INTO post_images(image_title, url, post_id)
VALUES ('here is an angry cat', 'https://purrpetrators.com/wp-content/uploads/2018/08/m2-2580x2580.jpg', 1),
       ('here is another angry cat','https://i2.wp.com/metro.co.uk/wp-content/uploads/2019/05/SEI_70586561-e1559296727769.jpg?quality=90&strip=all&zoom=1&resize=644%2C522&ssl=1', 1),
       ('a third cat', 'https://i.ytimg.com/vi/F70nR-eNyHA/hqdefault.jpg', 1);
use springblog_db;

INSERT INTO posts(body, title)
VALUES ( 'here', 'this'),
    ( 'there', 'what');

TRUNCATE post_details;
INSERT INTO post_details(history_of_post, is_awesome, topic_description, post_id) VALUES ('Here is the history of a small child, who once lived in a small village, in a very small state of Northern Branskill. This child\'s name was Timmy, and he was a little punk.', 1, 'uhuh', 1),
 ('history two',0,'thereitis',2);
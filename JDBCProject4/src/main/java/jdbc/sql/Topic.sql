CREATE TABLE topic
(
    topicId INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    name VARCHAR(255) NOT NULL ,
    slug VARCHAR(255) NOT NULL
);
INSERT INTO topic (topicId, name, slug) VALUES
                                            (1, 'Science', 'science'),
                                            (2, 'Gaming', 'gaming'),
                                            (3, 'Health', 'health'),
                                            (4, 'Travel', 'travel'),
                                            (5, 'Food', 'food'),
                                            (6, 'Fashion', 'fashion'),
                                            (7, 'Film', 'film'),
                                            (8, 'Literature', 'literature'),
                                            (9, 'History', 'history'),
                                            (10, 'Music', 'music');

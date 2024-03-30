CREATE TABLE post
(
    PostId INT PRIMARY KEY AUTO_INCREMENT UNIQUE ,
    userId INT NOT NULL ,
    title VARCHAR(255) NOT NULL ,
    slug VARCHAR(255) NOT NULL ,
    views INT DEFAULT 0,
    image VARCHAR(255) DEFAULT NULL,
    body TEXT,
    published INT DEFAULT 0,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES User (userId)
);
INSERT INTO post (PostId, userId, title, slug, views, image, body, published, createdAt, updatedAt)
VALUES
    (1, 1, 'Eerste bericht', 'eerste-bericht', 50, 'image1.jpg', 'John Doe', 1, NOW(), NOW()),
    (2, 1, 'Tweede bericht', 'tweede-bericht', 30, 'image2.jpg', 'Jane Smith', 1, NOW(), NOW()),
    (3, 2, 'Derde bericht', 'derde-bericht', 20, NULL, 'Mark Johnson', 0, NOW(), NOW()),
    (4, 2, 'Vierde bericht', 'vierde-bericht', 40, 'image3.jpg', 'Emily Brown', 1, NOW(), NOW()),
    (5, 3, 'Vijfde bericht', 'vijfde-bericht', 60, NULL, 'Michael Wilson', 1, NOW(), NOW()),
    (6, 3, 'Zesde bericht', 'zesde-bericht', 70, 'image4.jpg', 'Sophia Garcia', 0, NOW(), NOW()),
    (7, 4, 'Zevende bericht', 'zevende-bericht', 25, 'image5.jpg', 'Daniel Martinez', 1, NOW(), NOW()),
    (8, 4, 'Achtste bericht', 'achtste-bericht', 55, NULL, 'Olivia Lopez', 0, NOW(), NOW()),
    (9, 5, 'Negende bericht', 'negende-bericht', 80, 'image6.jpg', 'William Anderson', 1, NOW(), NOW()),
    (10, 5, 'Tiende bericht', 'tiende-bericht', 45, NULL, 'Emma Taylor', 1, NOW(), NOW());

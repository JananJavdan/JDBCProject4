CREATE TABLE postLike
(
    postId INT,
    userId INT,
    PRIMARY KEY (postId, userId),
    FOREIGN KEY (postId) REFERENCES Post (postId),
    FOREIGN KEY (userId) REFERENCES Post (userId)
);
INSERT INTO postLike (postId, userId)
VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (4, 2),
    (5, 3),
    (6, 3),
    (7, 4),
    (8, 4),
    (9, 5),
    (10, 5);
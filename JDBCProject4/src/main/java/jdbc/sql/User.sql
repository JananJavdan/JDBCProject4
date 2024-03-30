CREATE TABLE User (
                      userId INT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE ,
                      role VARCHAR(50),
                      password VARCHAR(255) NOT NULL,
                      createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO User (userId, username, email, role, password, createdAt, updatedAt) VALUES
                (1, 'john_doe', 'john@example.com', 'user', 'password123', NOW(), NOW()),
                (2, 'jane_smith', 'jane@example.com', 'admin', 'admin123', NOW(), NOW()),
                (3, 'bob_dylan', 'bob@example.com', 'user', 'bobpassword', NOW(), NOW()),
                (4, 'alice_jones', 'alice@example.com', 'user', 'alicepassword', NOW(), NOW()),
                (5, 'charlie_brown', 'charlie@example.com', 'user', 'charliepassword', NOW(), NOW()),
                (6, 'emma_davis', 'emma@example.com', 'user', 'emmapassword', NOW(), NOW()),
                (7, 'michael_lee', 'michael@example.com', 'admin', 'michaelpassword', NOW(), NOW()),
                (8, 'sophia_white', 'sophia@example.com', 'user', 'sophiapassword', NOW(), NOW()),
                (9, 'william_clark', 'william@example.com', 'user', 'williampassword', NOW(), NOW()),
                (10, 'olivia_hill', 'olivia@example.com', 'user', 'oliviapassword', NOW(), NOW());



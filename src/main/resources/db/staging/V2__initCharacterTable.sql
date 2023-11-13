CREATE TABLE Character_Sheet(
    id INTEGER NOT NULL AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    name VARCHAR(64),
    background VARCHAR(64),
    description TEXT,
    character_class VARCHAR(10),
    race VARCHAR(10),

);


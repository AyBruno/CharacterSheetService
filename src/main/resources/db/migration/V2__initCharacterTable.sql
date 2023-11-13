CREATE TABLE Character_Sheet(
    id INTEGER NOT NULL AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    name VARCHAR(64),
    background VARCHAR(64),
    description TEXT,
    character_class VARCHAR(10),
    race VARCHAR(10),
    death_successes TINYINT UNSIGNED,
    death_failures TINYINT UNSIGNED,
    max_hit_points SMALLINT UNSIGNED,
    current_hit_points SMALLINT UNSIGNED,
    experience_points MEDIUMINT UNSIGNED,
    gold SMALLINT UNSIGNED,
    PRIMARY KEY (id)
);


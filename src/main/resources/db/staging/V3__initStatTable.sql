CREATE TABLE Stats(
    character_id Integer,
    str TINYINT DEFAULT 0,
    dex TINYINT DEFAULT 0,
    con TINYINT DEFAULT 0,
    intl TINYINT DEFAULT 0,
    wis TINYINT DEFAULT 0,
    cha TINYINT DEFAULT 0,
    UNIQUE (character_id),
    PRIMARY KEY (character_id)
);
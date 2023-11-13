CREATE TABLE Actions(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(64),
    description TEXT,
    damage_type VARCHAR(20),
    is_homebrew BOOLEAN,
    spell_level TINYINT,
    PRIMARY KEY (id)
);

#Junction table between character_sheet and actions
CREATE TABLE Character_Actions(
    character_id INTEGER NOT NULL,
    action_id INTEGER NOT NULL
);
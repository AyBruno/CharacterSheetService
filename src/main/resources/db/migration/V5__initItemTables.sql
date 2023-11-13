CREATE TABLE Inventory_Item(
    id INTEGER AUTO_INCREMENT,
    name VARCHAR(64),
    description TEXT,
    quantity SMALLINT,
    is_homebrew BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE Character_Inventory(
    character_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL
)
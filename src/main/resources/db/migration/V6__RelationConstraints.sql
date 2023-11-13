ALTER TABLE Character_Sheet
    ADD CONSTRAINT FK_User_CharacterSheet
        FOREIGN KEY (user_id) REFERENCES User(id);

ALTER TABLE Stats
    ADD CONSTRAINT FK_CharacterSheet_Stat
        FOREIGN KEY (character_id) REFERENCES Character_Sheet(id);

ALTER TABLE Character_Actions
    ADD CONSTRAINT FK_CharacterSheet_CharacterActions
        FOREIGN KEY (character_id) REFERENCES Character_Sheet(id),
    ADD CONSTRAINT FK_Actions_CharacterActions
        FOREIGN KEY (action_id) REFERENCES Actions(id);

ALTER TABLE Character_Inventory
    ADD CONSTRAINT FK_CharacterSheet_CharacterInventory
        FOREIGN KEY (character_id) REFERENCES Character_Sheet(id),
    ADD CONSTRAINT FK_InventoryItem_CharacterInventory
        FOREIGN KEY (item_id) REFERENCES Inventory_Item(id);
package dev.abruno.dnd_service.character.util;

public enum CharacterClass{
    BARBARIAN(12), BARD(8), CLERIC(8),
    DRUID(8), FIGHTER(10), MONK(8),
    RANGER(10), ROGUE(8), PALADIN(10),
    SORCERER(6), WARLOCK(8), WIZARD(6);


    private final int hitDice;
    private CharacterClass(int hitDice){
        this.hitDice = hitDice;
    }

    public int getHitDice(){
        return this.hitDice;
    }
}


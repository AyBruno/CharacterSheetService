package dev.abruno.dnd_service.character.util;

import java.util.Arrays;
import java.util.List;

public enum CharacterClass{
    BARBARIAN(12, Arrays.asList(Ability.STR, Ability.CON)),
    BARD(8, Arrays.asList(Ability.DEX, Ability.CHA)),
    CLERIC(8, Arrays.asList(Ability.WIS, Ability.CHA)),
    DRUID(8, Arrays.asList(Ability.INT, Ability.WIS)),
    FIGHTER(10, Arrays.asList(Ability.STR, Ability.CON)),
    MONK(8, Arrays.asList(Ability.STR, Ability.DEX)),
    PALADIN(10, Arrays.asList(Ability.WIS, Ability.CHA)),
    RANGER(10, Arrays.asList(Ability.STR, Ability.DEX)),
    ROGUE(8, Arrays.asList(Ability.DEX, Ability.INT)),
    SORCERER(6, Arrays.asList(Ability.CON, Ability.CHA)),
    WARLOCK(8, Arrays.asList(Ability.WIS, Ability.CHA)),
    WIZARD(6, Arrays.asList(Ability.INT, Ability.WIS));

    private final int hitDice;
    private final List<Ability> savingThrows;
    CharacterClass(int hitDice, List<Ability> savingThrows){
        this.hitDice = hitDice;
        this.savingThrows = savingThrows;
    }

    public int getHitDice(){
        return this.hitDice;
    }

    public List<Ability> getSavingThrowProficiencies() {
        return this.savingThrows;
    }
}
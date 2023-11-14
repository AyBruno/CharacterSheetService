package dev.abruno.dnd_service.character.util;

public enum Skill {
    ACROBATICS(Ability.DEX), ANIMAL_HANDLING(Ability.WIS), ARCANA(Ability.INT),
    ATHLETICS(Ability.STR), DECEPTION(Ability.CHA), HISTORY(Ability.INT),
    INSIGHT(Ability.WIS), INTIMIDATION(Ability.CHA), INVESTIGATION(Ability.INT),
    MEDICINE(Ability.WIS), NATURE(Ability.INT), PERCEPTION(Ability.WIS),
    PERFORMANCE(Ability.CHA), PERSUASION(Ability.CHA), RELIGION(Ability.INT),
    SLEIGHT_OF_HAND(Ability.DEX), STEALTH(Ability.DEX), SURVIVAL(Ability.WIS);

    private final Ability ability;
    Skill(Ability ability){
        this.ability = ability;
    }
    public Ability getAbility(){
        return this.ability;
    }
}

package dev.abruno.dnd_service.character;

import dev.abruno.dnd_service.character.util.Ability;
import dev.abruno.dnd_service.character.util.Skill;

import java.util.Random;


public class CharacterStats {
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;

    CharacterStats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma){
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    CharacterStats(){
        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.intelligence = 0;
        this.wisdom = 0;
        this.charisma = 0;
    }

    public void randomize(){
        this.strength = generateRandomStat();
        this.dexterity = generateRandomStat();
        this.constitution = generateRandomStat();
        this.intelligence = generateRandomStat();
        this.wisdom = generateRandomStat();
        this.charisma = generateRandomStat();
    }

    public int getModifier(Ability ability){
        int abilityScore = 0;
        switch(ability){
            case Ability.STR: abilityScore = this.strength; break;
            case Ability.DEX: abilityScore = this.dexterity; break;
            case Ability.CON: abilityScore = this.constitution; break;
            case Ability.INT: abilityScore = this.intelligence; break;
            case Ability.WIS: abilityScore = this.wisdom; break;
            case Ability.CHA: abilityScore = this.charisma; break;
            default: return 0;
        }

        return calculateModifier(abilityScore);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }


    public static int calculateModifier(int abilityScore){
        return (abilityScore-10)/2;
    }

    private static int generateRandomStat(){
        Random rnd = new Random();
        int sum = 0;
        int smallest = 10;
        for(int i = 0; i < 4; i++){
            int roll = rnd.nextInt(1,7);
            sum += roll;

            smallest = Math.min(smallest, roll);
        }
        return sum - smallest;
    }

}

package dev.abruno.dnd_service.character;

import dev.abruno.dnd_service.character.util.StatHelper;

import java.util.ArrayList;
import java.util.List;


public class CharacterStats {
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    private List<StatHelper.Ability> savingThrowsList;
    private List<StatHelper.Skill> skillsList;

    CharacterStats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
                   List<StatHelper.Ability> savingThrowsList, List<StatHelper.Skill> skillsList){

        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.savingThrowsList = savingThrowsList;
        this.skillsList = skillsList;
    }

    CharacterStats(){
        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.intelligence = 0;
        this.wisdom = 0;
        this.charisma = 0;
        this.savingThrowsList = new ArrayList<>();
        this.skillsList = new ArrayList<>();
    }

    public void randomize(){
        this.strength = StatHelper.generateRandomStat();
        this.dexterity = StatHelper.generateRandomStat();
        this.constitution = StatHelper.generateRandomStat();
        this.intelligence = StatHelper.generateRandomStat();
        this.wisdom = StatHelper.generateRandomStat();
        this.charisma = StatHelper.generateRandomStat();
    }

    public int getModifier(StatHelper.Ability ability){
        int abilityScore = 0;
        switch(ability){
            case StatHelper.Ability.STR: abilityScore = this.strength; break;
            case StatHelper.Ability.DEX: abilityScore = this.dexterity; break;
            case StatHelper.Ability.CON: abilityScore = this.constitution; break;
            case StatHelper.Ability.INT: abilityScore = this.intelligence; break;
            case StatHelper.Ability.WIS: abilityScore = this.wisdom; break;
            case StatHelper.Ability.CHA: abilityScore = this.charisma; break;
            default: return 0;
        }

        return StatHelper.calculateModifier(abilityScore);
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

    public List<StatHelper.Ability> getSavingThrowsList() {
        return savingThrowsList;
    }

    public void setSavingThrowsList(List<StatHelper.Ability> savingThrowsList) {
        this.savingThrowsList = savingThrowsList;
    }

    public List<StatHelper.Skill> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<StatHelper.Skill> skillsList) {
        this.skillsList = skillsList;
    }

}

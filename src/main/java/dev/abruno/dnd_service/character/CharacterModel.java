package dev.abruno.dnd_service.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.ArrayList;

import dev.abruno.dnd_service.character.util.StatHelper;
import dev.abruno.dnd_service.item.InventoryItem;
import dev.abruno.dnd_service.action.Action;
import dev.abruno.dnd_service.character.util.CharacterClass;
import dev.abruno.dnd_service.character.util.Race;

public class CharacterModel {
    private int id, userId;
    private String name, background, description;
    private CharacterClass characterClass;
    private Race race;
    private CharacterStats stats;
    private List<InventoryItem> inventory;
    private List<Action> attacksAndSpells;


    private CharacterDeathSaves deathSaves;
    private int maxHitPoints, homebrewSpeed, currentHitPoints, experiencePoints, gold;

    private CharacterModel(CharacterBuilder builder){
        this.id = builder.id;
        this.userId = builder.userId;
        this.name = builder.name;
        this.characterClass = builder.characterClass;
        this.race = builder.race;
        this.background = builder.background;
        this.description = builder.description;
        this.homebrewSpeed = builder.homebrewSpeed;
        this.stats = builder.stats;
        this.inventory = builder.inventory;
        this.attacksAndSpells = builder.attacksAndSpells;
        this.maxHitPoints = builder.maxHitPoints;
        this.currentHitPoints = builder.currentHitPoints;
        this.experiencePoints = builder.experiencePoints;
        this.gold = builder.gold;
        this.deathSaves = builder.deathSaves;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CharacterStats getStats() {
        return stats;
    }

    public void setStats(CharacterStats stats) {
        this.stats = stats;
    }

    @JsonProperty("armorClass")
    public int getArmorClass(){
        return 10 + StatHelper.calculateModifier(this.stats.getDexterity());
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public List<Action> getAttacksAndSpells() {
        return attacksAndSpells;
    }

    public void setAttacksAndSpells(List<Action> attacksAndSpells) {
        this.attacksAndSpells = attacksAndSpells;
    }

    @JsonProperty("hitDice")
    public int getHitDice() {
        return this.characterClass.getHitDice();
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    @JsonProperty("speed")
    public int getSpeed() {
        return (this.race != null && homebrewSpeed == 0) ? this.race.getBaseSpeed() : homebrewSpeed;
    }

    public void setSpeed(int speed) {
        this.homebrewSpeed = speed;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public CharacterDeathSaves getDeathSaves() {
        return this.deathSaves;
    }


    public static class CharacterBuilder{
        int id, userId;
        private String name, background, description;
        private CharacterClass characterClass;
        private Race race;
        private CharacterStats stats;
        private List<InventoryItem> inventory;
        private List<Action> attacksAndSpells;

        private CharacterDeathSaves deathSaves;
        private int maxHitPoints, currentHitPoints, homebrewSpeed, experiencePoints, gold;

        public CharacterBuilder(int userId, String name){
            this.id = 0;
            this.userId = userId;
            this.name = name;
//            leaving these as null until assigned;
//            this.characterClass = "undecided";
//            this.race = "undecided";
//            this.background = "undecided";
//            this.description = "undecided";
//            this.inventory = new ArrayList<InventoryItem>();
//            this.attacksAndSpells = new ArrayList<Action>();
            //default values
            this.homebrewSpeed = 0;
            this.stats = new CharacterStats();
            this.experiencePoints = 0;
            this.gold = 0;
            this.deathSaves = new CharacterDeathSaves();
        }

        public CharacterBuilder setId(int id){
            this.id = id;
            return this;
        }

        public CharacterBuilder setStats(CharacterStats stats){
            this.stats = stats;
            return this;
        }

        public CharacterBuilder randomizeStats(){
            this.stats.randomize();
            return this;
        };

        public CharacterBuilder setCharacterClass(CharacterClass characterClass){
            this.characterClass = characterClass;
            return this;
        }

        public CharacterBuilder setHomebrewSpeed(int homebrewSpeed){
            this.homebrewSpeed = homebrewSpeed;
            return this;
        }

        public CharacterBuilder setRace(Race race){
            this.race = race;
            return this;
        }

        public CharacterBuilder setBackground(String background){
            this.background = background;
            return this;
        }

        public CharacterBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        public CharacterBuilder setDeathSaves(int successes, int failures){
            this.deathSaves.setSuccesses(successes);
            this.deathSaves.setFailures(failures);
            return this;
        }

        public CharacterBuilder setGold(int gold){
            this.gold = gold;
            return this;
        }

        public CharacterBuilder setExperience(int experiencePoints){
            this.experiencePoints = experiencePoints;
            return this;
        }

        public CharacterBuilder setInventory(List<InventoryItem> inventory){
            this.inventory = inventory;
            return this;
        }

        public CharacterModel build(){
            return new CharacterModel(this);
        }

    }

}

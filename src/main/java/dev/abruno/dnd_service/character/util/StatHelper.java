package dev.abruno.dnd_service.character;

import java.util.Random;

public class CharacterHelper {

    public enum CharacterClass{
        FIGHTER, ROGUE, BARBARIAN, WIZARD, DRUID, CLERIC, RANGER, MONK, PALADIN, WARLOCK
    }

    public enum Race{
        DRAGONBORN(30), DWARF(25), ELF(30),
        HALF_ELF(30), HALFLING(25), GNOME(25),
        HALF_ORC(30), HUMAN(30), TIEFLING(30);

        private final int baseSpeed;
        Race(int baseSpeed){
            this.baseSpeed = baseSpeed;
        }

        public int getBaseSpeed() {
            return baseSpeed;
        }
    }
    public enum Ability {
        STR, DEX, CON, INT, WIS, CHA
    }

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

    public static int calculateModifier(int val){
        return (val-10)/2;
    }

    public static int generateRandomStat(){
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

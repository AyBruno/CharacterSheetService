package dev.abruno.dnd_service.character.util;

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
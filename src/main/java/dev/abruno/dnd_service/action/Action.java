package dev.abruno.dnd_service.action;

public record Action(int id, String name, String description, DamageType damageType, boolean isHomebrew, int spellLevel) {
}

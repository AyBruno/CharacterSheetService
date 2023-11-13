package dev.abruno.dnd_service.character;

public class CharacterDeathSaves {
    private int successes;
    private int failures;

    CharacterDeathSaves(int successes, int failures){
        this.successes = successes;
        this.failures = failures;
    }

    CharacterDeathSaves(){
        this.successes = 0;
        this.failures = 0;
    }

    public int getSuccesses(){
        return this.successes;
    }

    public void setSuccesses(int successes){
        this.successes = successes;
    }

    public int getFailures(){
        return this.failures;
    }

    public void setFailures(int failures){
        this.failures = failures;
    }
}

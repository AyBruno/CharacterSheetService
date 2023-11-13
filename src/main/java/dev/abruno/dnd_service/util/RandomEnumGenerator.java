package dev.abruno.dnd_service.util;

import java.util.Random;

public class RandomEnumGenerator<T extends Enum<T>> {
    private static final Random rnd = new Random();
    private final T[] values;

    public RandomEnumGenerator(Class<T> e){
        this.values = e.getEnumConstants();
    }

    public T getRandomValue(){
        return values[rnd.nextInt(values.length)];
    }

}

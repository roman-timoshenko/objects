package service;

import model.DogSize;

import java.util.Random;

public class SizeGenerator {
    private static final DogSize[] VALUES = DogSize.values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static DogSize getRandomSize() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}

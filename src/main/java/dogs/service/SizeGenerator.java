package dogs.service;

import dogs.model.DogSize;

import java.util.Random;

public class SizeGenerator {
    private static DogSize[] values = DogSize.values();
    private static int size = values.length;
    private static Random random = new Random();

    public DogSize getRandomSize() {
        return values[random.nextInt(size)];
    }
}

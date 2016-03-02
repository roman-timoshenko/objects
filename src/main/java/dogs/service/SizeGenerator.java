package dogs.service;

import dogs.model.DogSize;

import java.util.Random;

public class SizeGenerator {
    private static DogSize[] values = DogSize.values();
    private static int size = values.length;

    public DogSize getRandomSize(Random random) {
        return values[random.nextInt(size)];
    }
}

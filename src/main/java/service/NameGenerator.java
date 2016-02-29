package service;

import dao.DogNameDao;

import java.io.IOException;
import java.util.Random;

public class NameGenerator {
    private final Random random;
    private final DogNameDao dogNameDao;

    public NameGenerator(Random random,DogNameDao dogNameDao ) {
        this.random = random;
        this.dogNameDao = dogNameDao;
    }

    public String getName(Random random, DogNameDao dogNameDao) throws IOException {
        return dogNameDao.getNames().get(random.nextInt(100) + 1);
    }
}

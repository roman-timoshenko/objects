package dogs.service;

import dogs.dao.DogNameDao;

import java.io.IOException;
import java.util.Random;

public class NameGenerator {
    private final Random random;
    private final DogNameDao dogNameDao;

    public NameGenerator(Random random,DogNameDao dogNameDao ) {
        this.random = random;
        this.dogNameDao = dogNameDao;
    }

    public String getName() throws IOException {
        return dogNameDao.getNames().get(random.nextInt(dogNameDao.getNames().size()) + 1);
    }
}

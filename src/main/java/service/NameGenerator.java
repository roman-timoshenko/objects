package service;

import dao.DogNameDao;

import java.io.IOException;
import java.util.Random;

public class NameGenerator {
    Random random = new Random();

    public String getName(DogNameDao dogNameDao) throws IOException {
        return dogNameDao.getNames().get(random.nextInt(100) + 1);
    }
}

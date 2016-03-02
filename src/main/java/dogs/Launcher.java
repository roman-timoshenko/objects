package dogs;

import dogs.dao.DogNameDao;
import dogs.service.*;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws IOException {
        Random random = new SecureRandom();
        DogNameDao dogNameDao = new DogNameDao("src/main/resources/names.txt");
        NameGenerator nameGenerator = new NameGenerator(random, dogNameDao.getNames());
        SizeGenerator sizeGenerator = new SizeGenerator();
        DogFactory dogFactory = new DogFactory(random, nameGenerator, sizeGenerator);
        DogsService dogsService = new DogsService(dogFactory);
        Sort sort = new Sort();
        Scanner scanner = new Scanner(System.in);
        Application application = new Application(scanner, dogsService, sort);
        application.run();
    }
}


package service;

import dao.DogNameDao;
import dog.Dog;
import dog.DogSize;

import java.io.IOException;
import java.util.Random;

public class DogFactory {

    private final Random random;
    private final NameGenerator nameGenerator;

    public DogFactory(Random random, NameGenerator nameGenerator){
        this.random = random;
        this.nameGenerator = nameGenerator;
    }

    public Dog createDog(String name) {
        int age = random.nextInt(10) + 1;
        DogSize size = DogSize.MEDIUM;
        return new Dog(name, size, age);
    }

    public Dog createDog(String name, DogSize size) {
        int age = random.nextInt(10) + 1;
        return new Dog(name, size, age);
    }

    public Dog createDog(String name, int age) {
        DogSize size = DogSize.SMALL;
        return new Dog(name, size, age);
    }

    public Dog createDog() throws IOException {
        DogSize size = DogSize.SMALL;
        int age = random.nextInt(10) + 1;
        String name = nameGenerator.getName(new Random(), new DogNameDao());
        return new Dog(name, size, age);
    }
}

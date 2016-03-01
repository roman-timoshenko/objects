package service;

import model.Dog;
import model.DogSize;

import java.io.IOException;
import java.util.Random;

public class DogFactory {

    private final Random random;
    private final NameGenerator nameGenerator;
    private final SizeGenerator sizeGenerator;

    public DogFactory(Random random, NameGenerator nameGenerator, SizeGenerator sizeGenerator){
        this.random = random;
        this.nameGenerator = nameGenerator;
        this.sizeGenerator = sizeGenerator;
    }

    public Dog createDog(String name) {
        int age = random.nextInt(20) + 1;
        DogSize size = sizeGenerator.getRandomSize();
        return new Dog(name, size, age);
    }

    public Dog createDog(String name, DogSize size) {
        int age = random.nextInt(20) + 1;
        return new Dog(name, size, age);
    }

    public Dog createDog(String name, int age) {
        DogSize size = sizeGenerator.getRandomSize();
        return new Dog(name, size, age);
    }

    public Dog createDog() throws IOException {
        DogSize size = DogSize.SMALL;
        int age = random.nextInt(20) + 1;
        String name = nameGenerator.getName();
        return new Dog(name, size, age);
    }
}

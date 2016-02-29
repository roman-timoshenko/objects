package service;

import dog.Dog;
import dog.DogSize;

import java.util.Random;

public class DogFactory {
    Random random = new Random();

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
}

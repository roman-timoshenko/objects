package dogs.service;

import dogs.model.Dog;

import java.io.IOException;

public class DogsService {
    private final DogFactory dogFactory;

    public DogsService(DogFactory dogFactory) {
        this.dogFactory = dogFactory;
    }

    public Dog[] createDogsArray(int size, String[] names) throws IOException {
        Dog[] dogs = new Dog[size];
        for (int i = 0; i < names.length; i++) {
            dogs[i] = dogFactory.createDog(names[i]);
        }
        for (int j = names.length; j<size; j++) {
            dogs[j] = dogFactory.createDog();
        }
        return dogs;

    }

}

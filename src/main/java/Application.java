import dao.DogNameDao;
import io.Input;
import model.Dog;
import service.DogFactory;
import service.DogsService;
import service.NameGenerator;
import service.SizeGenerator;

import java.io.IOException;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        DogNameDao dogNameDao = new DogNameDao();
        NameGenerator nameGenerator = new NameGenerator(random, dogNameDao);
        SizeGenerator sizeGenerator = new SizeGenerator();
        DogFactory dogFactory = new DogFactory(random, nameGenerator, sizeGenerator);
        DogsService dogsService = new DogsService(dogFactory);
        Input input = new Input();
        System.out.println("Please enter values");
        int size = input.getSize();
        System.out.println(size);
        String[] names = input.getNames();
        Dog[] dogs = dogsService.createDogsArray(size,names);
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
}

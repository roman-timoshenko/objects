package dogs;

import dogs.dao.DogNameDao;
import dogs.io.Input;
import dogs.model.Dog;
import dogs.service.*;
import dogs.service.comparator.AgeComparator;
import dogs.service.comparator.NameComparator;
import dogs.service.comparator.SizeComparator;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        DogNameDao dogNameDao = new DogNameDao();
        NameGenerator nameGenerator = new NameGenerator(random, dogNameDao);
        SizeGenerator sizeGenerator = new SizeGenerator();
        DogFactory dogFactory = new DogFactory(random, nameGenerator, sizeGenerator);
        DogsService dogsService = new DogsService(dogFactory);
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);
        Sort sort = new Sort();
        System.out.println("Please enter values");
        int size = input.getSize();
        String[] names = input.getNames();
        Dog[] dogs = dogsService.createDogsArray(size,names);
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println(" ");
        Dog[] sortDogs = sort.selectionsort(dogs,new NameComparator());
        for (Dog dog : sortDogs) {
            System.out.println(dog);
        }
    }
}

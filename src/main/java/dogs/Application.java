package dogs;

import dogs.dao.DogNameDao;
import dogs.io.Input;
import dogs.io.Output;
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
        DogNameDao dogNameDao = new DogNameDao("src/main/resources/names.txt");
        NameGenerator nameGenerator = new NameGenerator(random, dogNameDao);
        SizeGenerator sizeGenerator = new SizeGenerator();
        DogFactory dogFactory = new DogFactory(random, nameGenerator, sizeGenerator);
        DogsService dogsService = new DogsService(dogFactory);
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);
        Output output = new Output();
        Sort sort = new Sort();
        output.askUser("Please enter size and names");
        int size = input.getSize();
        String[] names = input.getNames();
        Dog[] dogs = dogsService.createDogsArray(size,names);
        output.askUser("Before sort");
        output.printArray(dogs);
        Dog[] sortDogs = sort.selectionsort(dogs,new NameComparator());
        output.askUser("After sort");
        output.printArray(sortDogs);
    }
}

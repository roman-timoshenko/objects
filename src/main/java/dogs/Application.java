package dogs;

import dogs.model.Dog;
import dogs.service.DogsService;
import dogs.service.Sort;
import dogs.service.comparator.NameComparator;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    private final Scanner scanner;
    private final DogsService dogsService;
    private final Sort sort;

    public Application(Scanner scanner, DogsService dogsService, Sort sort){
        this.scanner = scanner;
        this.dogsService = dogsService;
        this.sort = sort;
    }

    public int getSize(){
        return scanner.nextInt();}

    public String[] getNames(){
       String input = scanner.nextLine();
       String[] temp = input.split("\\s+");
        return temp;
    }

    public void printArray (Dog[] dogs){
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i].getName() + "\t" + dogs[i].getDogSize() + "\t" + dogs[i].getAge());
        }
        System.out.println(" ");

    }

    public void run() {
        try {
            System.out.println("Enter values");
            Dog[] dogs = dogsService.createDogsArray(getSize(),getNames());
            System.out.println("Default array of dogs");
            printArray(dogs);
            Dog[] sortDogs = sort.selectionsort(dogs,new NameComparator());
            System.out.println("Sorted array of dogs");
            printArray(sortDogs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

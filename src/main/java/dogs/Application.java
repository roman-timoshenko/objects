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

    public Application(Scanner scanner, DogsService dogsService, Sort sort) {
        this.scanner = scanner;
        this.dogsService = dogsService;
        this.sort = sort;
    }


  public Dog[] getDogs() throws IOException {
      String input = scanner.nextLine();
      String[] temp = input.trim().split("\\s+");
      String[] data = new String[temp.length-1];
      int size = 0;
      if (input.isEmpty()) {
          System.out.println("Something went wrong. Please try again");
      } else {
          size = Integer.parseInt(temp[0]);
          for (int i=0; i < temp.length-1; i++){
              data[i] = temp[i+1];
          }

      }
      return dogsService.createDogsArray(size, data);
    }

    public void printArray(Dog[] dogs) {
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i].getName() + "\t" + dogs[i].getDogSize() + "\t" + dogs[i].getAge());
        }
        System.out.println(" ");

    }

    public void run() {
        try {
            System.out.println("Please enter array size and dog names in the following format: 5 Sally Dog");
            Dog[] dogs = getDogs();
            System.out.println("Default array of dogs");
            printArray(dogs);
            Dog[] sortDogs = sort.selectionsort(dogs, new NameComparator());
            System.out.println("Sorted array of dogs");
            printArray(sortDogs);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



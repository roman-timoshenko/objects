package dogs.io;

import dogs.model.Dog;

public class Output {
    public void printArray (Dog[] dogs){
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i].getName() + "\t" + dogs[i].getDogSize() + "\t" + dogs[i].getAge());
        }
        System.out.println(" ");

    }
    public void askUser (String word){
        System.out.println(word);
    }
}

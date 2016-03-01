package dogs.service.comparator;

import dogs.model.Dog;

import java.util.Comparator;

public class AgeComparator implements Comparator<Dog>{
    public int compare(Dog o1, Dog o2) {
        int dogAge1 = o1.getAge();
        int dogAge2 = o2.getAge();
        return dogAge1 - dogAge2;
    }
}

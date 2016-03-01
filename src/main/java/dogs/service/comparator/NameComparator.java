package dogs.service.comparator;

import dogs.model.Dog;

import java.util.Comparator;

public class NameComparator implements Comparator<Dog>{

    public int compare(Dog o1, Dog o2) {
        String dogName1 = o1.getName();
        String dogName2 = o2.getName();
        return dogName1.compareTo(dogName2);
    }
}

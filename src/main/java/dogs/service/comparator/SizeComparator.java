package dogs.service.comparator;

import dogs.model.Dog;
import dogs.model.DogSize;

import java.util.Comparator;

public class SizeComparator implements Comparator<Dog> {
    public int compare(Dog o1, Dog o2) {
        DogSize dogSize1 = o1.getDogSize();
        DogSize dogSize2 = o2.getDogSize();
        return dogSize1.compareTo(dogSize2);
    }
}

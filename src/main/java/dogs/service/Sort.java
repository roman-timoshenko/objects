package dogs.service;

import dogs.model.Dog;

import java.util.Comparator;

public class Sort {
        public Dog[] selectionsort (Dog[] dogs, Comparator<Dog> comparator) {
            Dog min;
            Dog temp;
            for (int i = 0; i < dogs.length; i++){
                min = dogs[i];
                int k = i;
                for (int j=i+1; j < dogs.length; j++){
                    if (comparator.compare(dogs[j],min)<0){
                        min = dogs[j];
                        k = j;
                    }
                }
                temp = dogs[i];
                dogs[i] = dogs[k];
                dogs[k] = temp;
               // Collections.swap(array,i,k);
            }
            return dogs;
        }
}

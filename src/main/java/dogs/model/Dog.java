package dogs.model;

public class Dog implements Comparable<Dog>{
    private String name;
    private DogSize dogSize;
    private int age;

    public Dog(String name, DogSize dogSize, int age) {
        this.name = name;
        this.dogSize = dogSize;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public DogSize getDogSize() {
        return dogSize;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Dog anotherDog) throws ClassCastException {
        return this.name.compareTo(anotherDog.getName());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dogSize=" + dogSize +
                ", age=" + age +
                '}';
    }
}

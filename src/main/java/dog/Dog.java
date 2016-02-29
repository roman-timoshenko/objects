package dog;

public class Dog {
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dogSize=" + dogSize +
                ", age=" + age +
                '}';
    }
}

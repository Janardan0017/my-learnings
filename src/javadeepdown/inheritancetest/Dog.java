package javadeepdown.inheritancetest;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int teeth;

    @Override
    public void voice() {
        System.out.println("Bho bho bho......");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = new Dog();
        Dog dog = new Dog();
        animal.voice();
        animal1.voice();
        dog.voice();
    }
}

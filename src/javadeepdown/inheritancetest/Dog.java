package javadeepdown.inheritancetest;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int teeth;

    @Override
    public void voice() {
        System.out.println("Bho bho bho......");
    }

    protected void animalPrivateMethod() {
        System.out.println("Dog private method");
    }

    public static void animalStaticMethod() {
        System.out.println("Dog static method");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = new Dog();
        Dog dog = new Dog();
        animal.voice();
        Animal.animalStaticMethod();
        animal1.voice();
        Dog.animalStaticMethod();
        dog.voice();
    }
}

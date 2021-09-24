package javadeepdown.inheritancetest;

public class Animal {
    private String name;
    private int weight;

    public void voice() {
        System.out.println("Unknown......");
    }

    private void animalPrivateMethod() {
        System.out.println("Animal private method");
    }

    public static void animalStaticMethod() {
        System.out.println("Animal static method");
    }
}

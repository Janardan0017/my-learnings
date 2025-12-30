package javadeepdown.java8;

@FunctionalInterface
public interface Interface1 {

    int sum(int a, int b);

    default void log(String str) {
        System.out.println("Interface 1 logging: " + str);
    }

    static void print(String str) {
        System.out.println("Interface 1");
    }
}

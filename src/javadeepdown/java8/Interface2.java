package javadeepdown.java8;

@FunctionalInterface
public interface Interface2 {

    int method1();

    default void log(String str) {
        System.out.println("Interface 2 logging: " + str);
    }

    default int sum(int a, int b) {
        return a + b;
    }
}

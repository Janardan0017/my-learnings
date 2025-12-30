package javadeepdown;

import java.util.function.BiConsumer;

public class MainClass {

    public static void main(String[] args) throws InvalidDataException {
//        Cycle cycle = new Cycle(1, "Jd");
//        System.out.println(cycle);
//        Cycle cycle1 = new Cycle(-1, "Kd");
//        cycle1.setId(-3);
//        System.out.println(cycle1);

        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a + b);
        biConsumer.accept(4, 5);
    }
}

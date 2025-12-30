package javadeepdown.java8;

import java.util.function.BiFunction;

public class FunctionalInterfaceAndLambdaExpression {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++)
                System.out.println("Running thread");
        };
        runnable.run();

        Interface1 interface1 = Integer::sum;
        System.out.println(interface1.sum(1, 5));

        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;
        System.out.println(biFunction.apply(1, 2));

    }
}

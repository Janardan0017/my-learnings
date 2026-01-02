package javadeepdown.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        // adding even numbers from list
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) list.add(i);
        int sum = list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        LongStream longStream = Arrays.stream(new long[]{1L, 2L, 3L});
        IntStream intStream = "abc".chars();
        intStream.forEach(System.out::println);
    }
}

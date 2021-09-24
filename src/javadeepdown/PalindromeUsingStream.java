package javadeepdown;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PalindromeUsingStream {

    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        boolean isPalindrome = IntStream.range(0, str.length() / 2).peek(System.out::println)
                .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
        System.out.println(isPalindrome);

        IntPredicate isEven = x -> x % 2 == 0;
        IntStream.range(0,100).filter(isEven).forEach(System.out::println);
    }
}

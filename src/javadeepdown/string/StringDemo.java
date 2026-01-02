package javadeepdown.string;

import java.util.StringJoiner;

public class StringDemo {

    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
        stringJoiner.add("a");
        stringJoiner.add("a");
        stringJoiner.add("a");
        System.out.println(stringJoiner);
    }
}

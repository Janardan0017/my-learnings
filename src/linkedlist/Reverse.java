package linkedlist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reverse {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        reverse(list);
    }

    static void reverse(List<Integer> list) {
        if(list.isEmpty()) {
            return;
        }
        int temp = list.get(0);
        list.remove(0);
        reverse(list);
        System.out.println(temp);
    }
}

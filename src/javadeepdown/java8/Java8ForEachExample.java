package javadeepdown.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Java8ForEachExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 11; i++)
            list.add(i);

        //traverse using iterator
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer val = itr.next();
            System.out.print(val + " ");
        }
        System.out.println();

        //traverse using foreach method of iterable interface with anonymous class
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer + " ");
            }
        });
        System.out.println();

        //traverse using foreach method of iterable interface with using lambda expression
        list.forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        //traversing with consumer interface implementation
        MyConsumer action = new MyConsumer();
        list.forEach(action);

    }
}

class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.print(integer + " ");
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class CollectionTest {

    public static void main(String[] args) {
        Collection<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(1);
        Collection<Integer> arrayDeque = new ArrayDeque<>();
        Collection<Integer> arrayList = new ArrayList<>();
        System.out.println(arrayDeque.size());
    }
}

package companies.accolite;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<Integer, String> list = new LinkedHashMap<>();
        list.put(1, "A");
        list.put(3, "C");
        list.put(2, "B");
        list.put(5, "E");
        list.put(4, "D");
        list.put(6, "F");
        System.out.println(list);
    }

}

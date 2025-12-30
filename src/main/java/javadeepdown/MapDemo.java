package javadeepdown;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 11);
        System.out.println(map.size());
        map.put(2, 22);
        System.out.println(map.containsValue(2));
        map.values().remove(22);
        map.values().removeIf(e -> e == 11);
        System.out.println(map);
        map.put(1, 11);
        map.put(2, 22);
        map.put(3, 33);
        System.out.println(map.getOrDefault(2, 123));
        System.out.println(map.getOrDefault(4, 44));
        map.remove(3, 123); // should not remove as 3 is mapped to 33 not 123
        System.out.println(map);
        map.compute(3, (k, v) -> v == null ? 1 : v + 1);
        map.compute(4, (k, v) -> v == null ? 1 : v + 1);
        System.out.println(map);
        map.merge(5, 1, (k, v) -> v + 1);
        System.out.println(map);
        map.merge(5, 1, (k, v) -> v + 1);
        System.out.println(map);
    }
}

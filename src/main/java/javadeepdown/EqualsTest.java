package javadeepdown;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EqualsTest {

    public static void main(String[] args) {
        ET et1 = new ET(1, "A");
        List<ET> list1 = new ArrayList<>();
        list1.add(et1);
        ET et2 = new ET(1, "A");
        List<ET> list2 = new ArrayList<>();
        list2.add(et2);
        System.out.println(list2.equals(list1));
    }
}


class ET {
    public int id;
    public String name;

    public ET(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ET et = (ET) o;
        return id == et.id && Objects.equals(name, et.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

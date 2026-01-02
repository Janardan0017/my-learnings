package javadeepdown;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator {

    public static void main(String[] args) {
        Contract c1 = new Contract(4, "DDD", LocalDateTime.now(), false);
        Contract c2 = new Contract(2, "BBB", LocalDateTime.now(), false);
        Contract c3 = new Contract(1, "AAA", LocalDateTime.now(), false);
        Contract c4 = new Contract(3, "CCC", LocalDateTime.now(), false);
        List<Contract> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.sort(new NameCompare());
        System.out.println(list);
    }
}

class Contract implements Comparable<Contract> {
    public int id;
    public String name;
    public LocalDateTime time;
    public boolean completed;

    public Contract(int id, String name, LocalDateTime time, boolean completed) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.completed = completed;
    }

    @Override
    public int compareTo(Contract contract) {
        return contract.id - this.id;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", completed=" + completed +
                '}';
    }
}


class NameCompare implements Comparator<Contract> {

    @Override
    public int compare(Contract c1, Contract c2) {
        return c1.name.compareTo(c2.name);
    }
}

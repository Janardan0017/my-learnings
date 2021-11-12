package javadeepdown;

public class EqualsTest {

    public static void main(String[] args) {
        ET et1 = new ET(1, "A");
        ET et2 = new ET(1, "A");
        System.out.println(et1.equals(et2));
    }
}


class ET {
    public int id;
    public final String name;

    public ET(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ET)) return false;
//        ET et = (ET) o;
//        return id == et.id && Objects.equals(name, et.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }

}

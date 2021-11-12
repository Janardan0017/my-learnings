package javadeepdown.java8;

import java.util.Objects;

public abstract class Abstract1 {

    private int id;
    private String name;
    private String phone;

    protected Abstract1(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    abstract void log(String str);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Abstract1)) return false;
        Abstract1 abstract1 = (Abstract1) o;
        return id == abstract1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone);
    }
}

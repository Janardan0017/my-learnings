package util.models;

public class IdName {

    public long id;
    public String name;

    public IdName() {
    }

    public IdName(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "IdName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

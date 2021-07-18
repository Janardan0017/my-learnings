package javadeepdown;

public class Cycle {

    private int id;
    private String name;

    public Cycle(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidDataException {
        if (id > 0) {
            this.id = id;
        } else {
            throw new InvalidDataException("Invalid id: " + id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package javadeepdown;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableClassTest {

    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass("Jd", Stream.of("Hindi", "English").collect(Collectors.toList()));
        System.out.println(immutableClass);
        immutableClass.getSubjects().add("Math");
        System.out.println(immutableClass);
    }
}

// make class as final to restrict inheritance
final class ImmutableClass {

    private final String name;
    private final List<String> subjects;

    public ImmutableClass(String name, List<String> subjects) {
        this.name = name;
        this.subjects = new ArrayList<>(subjects);
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return new ArrayList<>(subjects);
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emp350 on 3/04/20
 */
public class Test {
    public static void main(String[] args) {
        Map<Person, String> persons = new HashMap<>();
        persons.put(new Person(12, 12), "JD12");
        persons.put(new Person(34, 15), "JD15");
        persons.put(new Person(56, 25), "JD25");
        persons.put(new Person(86, 33), "JD33");
        persons.put(new Person(76, 12), "JD12");
        persons.put(new Person(90, 15), "JD15");
        persons.put(new Person(34, 25), "JD25");

        Map<Person, List<String>> map2 = new HashMap<>();
        for(Map.Entry<Person, String> person: persons.entrySet()){
            Person key = person.getKey();
        }

    }

    public boolean isSameAge(Person p1, Person p2){
        return p1.getAge() == p2.getAge();
    }
}

class Person{
    private double score;
    private int age;

    public Person(double score, int age){
        this.score = score;
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Name{
    public String name;
}
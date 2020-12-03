package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created for interview-preperation on 13/06/20
 */
public class StackOverflow1 {

    public static void solve2(Map<Person, String> personAndNameMap) {
        List<Person> persons = new ArrayList<>();
        personAndNameMap.entrySet().stream()
                // collect the list of persons group by age (it collect list of persons with same age)
                .collect(Collectors.groupingBy(e -> e.getKey().getAge()))
                // iterate the persons of same age
                .forEach((key, value) -> {
                    // set the best score to 0 among them
                    double bestScore = 0;
                    // create a map to store name and their line score
                    Map<String, Double> nameAndScoreMap = new HashMap<>();
                    for (Map.Entry<Person, String> map : value) {
                        // check and update best score
                        bestScore = Math.max(bestScore, map.getKey().getLineScoreMax());
                        // add person name and his line score in map
                        nameAndScoreMap.put(map.getValue(), map.getKey().getLineScoreMax());
                    }
                    // add the person in list
                    persons.add(new Person(key, bestScore, nameAndScoreMap));
                });
        System.out.println(persons);
    }

    public static void main(String[] args) {
        Map<Person, String> personMap = new HashMap<>();
        personMap.put(new Person(12, 50), "alex");
        personMap.put(new Person(16, 50), "miki");
        personMap.put(new Person(5, 100), "shi");
        personMap.put(new Person(4, 50), "rafi");
        personMap.put(new Person(1, 50), "sharbel");
        personMap.put(new Person(5, 0), "thomas");
        personMap.put(new Person(14, 60), "thomy");
        personMap.put(new Person(14, 50), "angelos");
        personMap.put(new Person(11, 50), "musti");
        personMap.put(new Person(11, 100), "allo");
        personMap.put(new Person(2, 50), "evi");

        solve2(personMap);
    }
}

class Person {
    private int age;
    private double lineScoreMax;
    private Map<String, Double> nameAndScoreMap;

    public Person(int age, double lineScoreMax) {
        this.age = age;
        this.lineScoreMax = lineScoreMax;
    }

    public Person(int age, double lineScoreMax, Map<String, Double> nameAndScoreMap) {
        this.age = age;
        this.lineScoreMax = lineScoreMax;
        this.nameAndScoreMap = nameAndScoreMap;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getLineScoreMax() {
        return lineScoreMax;
    }

    public void setLineScoreMax(double lineScoreMax) {
        this.lineScoreMax = lineScoreMax;
    }

    public Map<String, Double> getNameAndScoreMap() {
        return nameAndScoreMap;
    }

    public void setNameAndScoreMap(Map<String, Double> nameAndScoreMap) {
        this.nameAndScoreMap = nameAndScoreMap;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + lineScoreMax +
                ", nameScoreTogether=" + nameAndScoreMap +
                '}';
    }
}
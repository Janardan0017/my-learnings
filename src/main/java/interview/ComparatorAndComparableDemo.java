import java.util.*;

// Example class to demonstrate Comparable and Comparator
class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double gpa;
    
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
    }
    
    // Comparable implementation - defines natural ordering
    @Override
    public int compareTo(Student other) {
        // Primary sort: by name (alphabetical)
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        // Secondary sort: by age (ascending) if names are equal
        return Integer.compare(this.age, other.age);
    }
}

// Custom Comparator classes
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

class GpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Sort by GPA in descending order (highest first)
        return Double.compare(s2.getGpa(), s1.getGpa());
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

public class ComparatorAndComparableDemo {
    public static void main(String[] args) {
        // Create sample students
        List<Student> students = Arrays.asList(
            new Student("Alice", 20, 3.8),
            new Student("Bob", 22, 3.5),
            new Student("Alice", 19, 3.9),
            new Student("Charlie", 21, 3.7),
            new Student("David", 20, 3.6)
        );
        
        System.out.println("=== ORIGINAL LIST ===");
        students.forEach(System.out::println);
        
        // 1. Using Comparable (natural ordering)
        System.out.println("\n=== SORTED BY NATURAL ORDER (Comparable) ===");
        System.out.println("Natural order: Name (ascending), then Age (ascending)");
        List<Student> sortedByNatural = new ArrayList<>(students);
        Collections.sort(sortedByNatural);
        sortedByNatural.forEach(System.out::println);
        
        // 2. Using Comparator - different sorting criteria
        System.out.println("\n=== SORTED BY AGE (Comparator) ===");
        List<Student> sortedByAge = new ArrayList<>(students);
        Collections.sort(sortedByAge, new AgeComparator());
        sortedByAge.forEach(System.out::println);
        
        System.out.println("\n=== SORTED BY GPA DESCENDING (Comparator) ===");
        List<Student> sortedByGpa = new ArrayList<>(students);
        Collections.sort(sortedByGpa, new GpaComparator());
        sortedByGpa.forEach(System.out::println);
        
        // 3. Using Lambda expressions (Java 8+)
        System.out.println("\n=== SORTED BY NAME USING LAMBDA ===");
        List<Student> sortedByName = new ArrayList<>(students);
        Collections.sort(sortedByName, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        sortedByName.forEach(System.out::println);
        
        // 4. Using method references
        System.out.println("\n=== SORTED BY AGE USING METHOD REFERENCE ===");
        List<Student> sortedByAgeMethodRef = new ArrayList<>(students);
        Collections.sort(sortedByAgeMethodRef, Comparator.comparing(Student::getAge));
        sortedByAgeMethodRef.forEach(System.out::println);
        
        // 5. Chaining comparators
        System.out.println("\n=== SORTED BY GPA DESC, THEN BY NAME ASC ===");
        List<Student> sortedByGpaThenName = new ArrayList<>(students);
        Collections.sort(sortedByGpaThenName, 
            Comparator.comparing(Student::getGpa).reversed()
                     .thenComparing(Student::getName));
        sortedByGpaThenName.forEach(System.out::println);
        
        // 6. Using Arrays.sort() with custom comparator
        System.out.println("\n=== SORTING ARRAY BY AGE ===");
        Student[] studentArray = students.toArray(new Student[0]);
        Arrays.sort(studentArray, new AgeComparator());
        Arrays.stream(studentArray).forEach(System.out::println);
        
        // 7. Demonstrating the compareTo method
        System.out.println("\n=== COMPARISON EXAMPLES ===");
        Student alice1 = new Student("Alice", 20, 3.8);
        Student alice2 = new Student("Alice", 19, 3.9);
        Student bob = new Student("Bob", 22, 3.5);
        
        System.out.println("alice1.compareTo(alice2): " + alice1.compareTo(alice2));
        System.out.println("alice1.compareTo(bob): " + alice1.compareTo(bob));
        System.out.println("bob.compareTo(alice1): " + bob.compareTo(alice1));
        
        // 8. Using TreeSet (automatically sorted)
        System.out.println("\n=== TREESET (AUTOMATIC SORTING) ===");
        Set<Student> studentSet = new TreeSet<>(students);
        studentSet.forEach(System.out::println);
    }
} 
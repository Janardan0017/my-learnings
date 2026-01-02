package interview;

public class PrintExample {
    public static void main(String[] args) {
        // Basic string printing
        System.out.println("Hello, World!");
        
        // Printing different data types
        System.out.println(42);                    // int
        System.out.println(3.14);                  // double
        System.out.println(true);                  // boolean
        System.out.println('A');                   // char
        
        // Printing variables
        String name = "John";
        int age = 25;
        System.out.println("Name: " + name + ", Age: " + age);
        
        // Printing objects (calls toString() method)
        Person person = new Person("Alice", 30);
        System.out.println(person);
        
        // Multiple println calls
        System.out.println("Line 1");
        System.out.println("Line 2");
        System.out.println("Line 3");
        
        // Empty println for spacing
        System.out.println();
        System.out.println("After empty line");
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
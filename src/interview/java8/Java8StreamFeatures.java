package interview.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamFeatures {
    
    // Sample data for demonstrations
    private static List<Employee> employees = Arrays.asList(
        new Employee("John", 25, "IT", 50000, "Male"),
        new Employee("Jane", 30, "HR", 45000, "Female"),
        new Employee("Bob", 35, "IT", 60000, "Male"),
        new Employee("Alice", 28, "Finance", 55000, "Female"),
        new Employee("Charlie", 32, "IT", 70000, "Male"),
        new Employee("Diana", 27, "HR", 48000, "Female"),
        new Employee("Eve", 29, "Finance", 52000, "Female"),
        new Employee("Frank", 31, "IT", 65000, "Male")
    );
    
    private static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private static List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
    
    public static void main(String[] args) {
        Java8StreamFeatures demo = new Java8StreamFeatures();
        
        System.out.println("=== JAVA 8 STREAM FEATURES DEMONSTRATION ===\n");
        
        // 1. Stream Creation
        demo.streamCreation();
        
        // 2. Intermediate Operations
        demo.intermediateOperations();
        
        // 3. Terminal Operations
        demo.terminalOperations();
        
        // 4. Collectors
        demo.collectors();
        
        // 5. Parallel Streams
        demo.parallelStreams();
        
        // 6. Advanced Features
        demo.advancedFeatures();
    }
    
    // ==================== 1. STREAM CREATION ====================
    public void streamCreation() {
        System.out.println("1. STREAM CREATION");
        System.out.println("==================");
        
        // From Collection
        Stream<Employee> stream1 = employees.stream();
        System.out.println("From Collection: " + stream1.count() + " employees");
        
        // From Array
        Stream<String> stream2 = Arrays.stream(new String[]{"a", "b", "c"});
        System.out.println("From Array: " + stream2.count() + " elements");
        
        // Using Stream.of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Using Stream.of(): " + stream3.count() + " elements");
        
        // Empty Stream
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Empty Stream: " + emptyStream.count() + " elements");
        
        // Infinite Stream
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        System.out.println("Infinite Stream (first 5): " + 
            infiniteStream.limit(5).collect(Collectors.toList()));
        
        // Stream from Supplier
        Stream<Double> randomStream = Stream.generate(Math::random);
        System.out.println("Random Stream (first 3): " + 
            randomStream.limit(3).collect(Collectors.toList()));
        
        System.out.println();
    }
    
    // ==================== 2. INTERMEDIATE OPERATIONS ====================
    public void intermediateOperations() {
        System.out.println("2. INTERMEDIATE OPERATIONS");
        System.out.println("==========================");
        
        // filter() - Filter elements based on condition
        System.out.println("FILTER - IT Department Employees:");
        employees.stream()
            .filter(emp -> "IT".equals(emp.getDepartment()))
            .forEach(emp -> System.out.println("  " + emp.getName()));
        
        // map() - Transform elements
        System.out.println("\nMAP - Employee Names in Uppercase:");
        employees.stream()
            .map(Employee::getName)
            .map(String::toUpperCase)
            .forEach(name -> System.out.println("  " + name));
        
        // flatMap() - Flatten nested collections
        System.out.println("\nFLATMAP - All Characters in Names:");
        employees.stream()
            .map(Employee::getName)
            .flatMap(name -> name.chars().mapToObj(c -> (char) c))
            .forEach(c -> System.out.print(c + " "));
        System.out.println();
        
        // distinct() - Remove duplicates
        System.out.println("\nDISTINCT - Unique Departments:");
        employees.stream()
            .map(Employee::getDepartment)
            .distinct()
            .forEach(dept -> System.out.println("  " + dept));
        
        // sorted() - Sort elements
        System.out.println("\nSORTED - Employees by Salary (descending):");
        employees.stream()
            .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
            .forEach(emp -> System.out.println("  " + emp.getName() + " - $" + emp.getSalary()));
        
        // peek() - Debug/perform side effects
        System.out.println("\nPEEK - Debugging Stream:");
        List<String> result = employees.stream()
            .peek(emp -> System.out.println("  Processing: " + emp.getName()))
            .map(Employee::getName)
            .peek(name -> System.out.println("  Mapped to: " + name))
            .collect(Collectors.toList());
        
        // limit() - Limit number of elements
        System.out.println("\nLIMIT - First 3 Employees:");
        employees.stream()
            .limit(3)
            .forEach(emp -> System.out.println("  " + emp.getName()));
        
        // skip() - Skip first n elements
        System.out.println("\nSKIP - Skip first 2 Employees:");
        employees.stream()
            .skip(2)
            .forEach(emp -> System.out.println("  " + emp.getName()));
        
        // takeWhile() - Take elements while condition is true (Java 9+)
        System.out.println("\nTAKEWHILE - Numbers less than 5:");
        numbers.stream()
            .takeWhile(n -> n < 5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // dropWhile() - Drop elements while condition is true (Java 9+)
        System.out.println("\nDROPWHILE - Drop numbers less than 5:");
        numbers.stream()
            .dropWhile(n -> n < 5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.println();
    }
    
    // ==================== 3. TERMINAL OPERATIONS ====================
    public void terminalOperations() {
        System.out.println("3. TERMINAL OPERATIONS");
        System.out.println("======================");
        
        // forEach() - Perform action on each element
        System.out.println("FOREACH - Print all employee names:");
        employees.stream()
            .forEach(emp -> System.out.println("  " + emp.getName()));
        
        // collect() - Collect elements into collection
        System.out.println("\nCOLLECT - List of IT employees:");
        List<Employee> itEmployees = employees.stream()
            .filter(emp -> "IT".equals(emp.getDepartment()))
            .collect(Collectors.toList());
        itEmployees.forEach(emp -> System.out.println("  " + emp.getName()));
        
        // toArray() - Convert to array
        System.out.println("\nTOARRAY - Employee names as array:");
        String[] names = employees.stream()
            .map(Employee::getName)
            .toArray(String[]::new);
        System.out.println("  " + Arrays.toString(names));
        
        // reduce() - Reduce elements to single value
        System.out.println("\nREDUCE - Sum of all salaries:");
        int totalSalary = employees.stream()
            .mapToInt(Employee::getSalary)
            .reduce(0, Integer::sum);
        System.out.println("  Total Salary: $" + totalSalary);
        
        // reduce() - Find maximum salary
        System.out.println("\nREDUCE - Maximum salary:");
        Optional<Employee> maxSalaryEmp = employees.stream()
            .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
        maxSalaryEmp.ifPresent(emp -> 
            System.out.println("  " + emp.getName() + " - $" + emp.getSalary()));
        
        // min() - Find minimum element
        System.out.println("\nMIN - Youngest employee:");
        Optional<Employee> youngest = employees.stream()
            .min(Comparator.comparing(Employee::getAge));
        youngest.ifPresent(emp -> 
            System.out.println("  " + emp.getName() + " - Age: " + emp.getAge()));
        
        // max() - Find maximum element
        System.out.println("\nMAX - Highest paid employee:");
        Optional<Employee> highestPaid = employees.stream()
            .max(Comparator.comparing(Employee::getSalary));
        highestPaid.ifPresent(emp -> 
            System.out.println("  " + emp.getName() + " - $" + emp.getSalary()));
        
        // count() - Count elements
        System.out.println("\nCOUNT - Number of female employees:");
        long femaleCount = employees.stream()
            .filter(emp -> "Female".equals(emp.getGender()))
            .count();
        System.out.println("  Female employees: " + femaleCount);
        
        // anyMatch() - Check if any element matches condition
        System.out.println("\nANYMATCH - Any employee with salary > 60000:");
        boolean hasHighSalary = employees.stream()
            .anyMatch(emp -> emp.getSalary() > 60000);
        System.out.println("  Has high salary employee: " + hasHighSalary);
        
        // allMatch() - Check if all elements match condition
        System.out.println("\nALLMATCH - All employees older than 20:");
        boolean allAdults = employees.stream()
            .allMatch(emp -> emp.getAge() > 20);
        System.out.println("  All adults: " + allAdults);
        
        // noneMatch() - Check if no element matches condition
        System.out.println("\nNONEMATCH - No employee with salary < 40000:");
        boolean noLowSalary = employees.stream()
            .noneMatch(emp -> emp.getSalary() < 40000);
        System.out.println("  No low salary: " + noLowSalary);
        
        // findFirst() - Find first element
        System.out.println("\nFINDFIRST - First IT employee:");
        Optional<Employee> firstIT = employees.stream()
            .filter(emp -> "IT".equals(emp.getDepartment()))
            .findFirst();
        firstIT.ifPresent(emp -> 
            System.out.println("  " + emp.getName()));
        
        // findAny() - Find any element
        System.out.println("\nFINDANY - Any female employee:");
        Optional<Employee> anyFemale = employees.stream()
            .filter(emp -> "Female".equals(emp.getGender()))
            .findAny();
        anyFemale.ifPresent(emp -> 
            System.out.println("  " + emp.getName()));
        
        System.out.println();
    }
    
    // ==================== 4. COLLECTORS ====================
    public void collectors() {
        System.out.println("4. COLLECTORS");
        System.out.println("=============");
        
        // toList() - Collect to List
        System.out.println("TOLIST - All employee names:");
        List<String> allNames = employees.stream()
            .map(Employee::getName)
            .collect(Collectors.toList());
        System.out.println("  " + allNames);
        
        // toSet() - Collect to Set
        System.out.println("\nTOSET - Unique departments:");
        Set<String> departments = employees.stream()
            .map(Employee::getDepartment)
            .collect(Collectors.toSet());
        System.out.println("  " + departments);
        
        // toMap() - Collect to Map
        System.out.println("\nTOMAP - Name to Salary mapping:");
        Map<String, Integer> nameToSalary = employees.stream()
            .collect(Collectors.toMap(
                Employee::getName,
                Employee::getSalary
            ));
        System.out.println("  " + nameToSalary);
        
        // groupingBy() - Group by department
        System.out.println("\nGROUPINGBY - Group by department:");
        Map<String, List<Employee>> byDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
        byDepartment.forEach((dept, emps) -> {
            System.out.println("  " + dept + ": " + 
                emps.stream().map(Employee::getName).collect(Collectors.toList()));
        });
        
        // groupingBy() with counting
        System.out.println("\nGROUPINGBY with COUNTING - Employee count by department:");
        Map<String, Long> deptCount = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("  " + deptCount);
        
        // groupingBy() with averaging
        System.out.println("\nGROUPINGBY with AVERAGING - Average salary by department:");
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingInt(Employee::getSalary)
            ));
        System.out.println("  " + avgSalaryByDept);
        
        // partitioningBy() - Partition by condition
        System.out.println("\nPARTITIONINGBY - Partition by salary > 50000:");
        Map<Boolean, List<Employee>> bySalary = employees.stream()
            .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 50000));
        System.out.println("  High salary: " + 
            bySalary.get(true).stream().map(Employee::getName).collect(Collectors.toList()));
        System.out.println("  Low salary: " + 
            bySalary.get(false).stream().map(Employee::getName).collect(Collectors.toList()));
        
        // joining() - Join strings
        System.out.println("\nJOINING - All names joined:");
        String allNamesJoined = employees.stream()
            .map(Employee::getName)
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("  " + allNamesJoined);
        
        // summarizingInt() - Get statistics
        System.out.println("\nSUMMARIZINGINT - Salary statistics:");
        IntSummaryStatistics salaryStats = employees.stream()
            .collect(Collectors.summarizingInt(Employee::getSalary));
        System.out.println("  Count: " + salaryStats.getCount());
        System.out.println("  Sum: $" + salaryStats.getSum());
        System.out.println("  Min: $" + salaryStats.getMin());
        System.out.println("  Max: $" + salaryStats.getMax());
        System.out.println("  Average: $" + String.format("%.2f", salaryStats.getAverage()));
        
        // reducing() - Custom reduction
        System.out.println("\nREDUCING - Total salary using reducing:");
        int totalSalary = employees.stream()
            .collect(Collectors.reducing(0, Employee::getSalary, Integer::sum));
        System.out.println("  Total Salary: $" + totalSalary);
        
        System.out.println();
    }
    
    // ==================== 5. PARALLEL STREAMS ====================
    public void parallelStreams() {
        System.out.println("5. PARALLEL STREAMS");
        System.out.println("===================");
        
        // Sequential stream
        long startTime = System.currentTimeMillis();
        List<String> sequentialResult = employees.stream()
            .filter(emp -> emp.getSalary() > 50000)
            .map(Employee::getName)
            .collect(Collectors.toList());
        long sequentialTime = System.currentTimeMillis() - startTime;
        
        // Parallel stream
        startTime = System.currentTimeMillis();
        List<String> parallelResult = employees.parallelStream()
            .filter(emp -> emp.getSalary() > 50000)
            .map(Employee::getName)
            .collect(Collectors.toList());
        long parallelTime = System.currentTimeMillis() - startTime;
        
        System.out.println("SEQUENTIAL vs PARALLEL:");
        System.out.println("  Sequential time: " + sequentialTime + "ms");
        System.out.println("  Parallel time: " + parallelTime + "ms");
        System.out.println("  Results equal: " + sequentialResult.equals(parallelResult));
        
        // Parallel stream with custom thread pool
        System.out.println("\nPARALLEL with custom thread pool:");
        // ForkJoinPool customThreadPool = new ForkJoinPool(4);
        // List<String> customParallelResult = customThreadPool.submit(() ->
        //     employees.parallelStream()
        //         .filter(emp -> emp.getSalary() > 50000)
        //         .map(Employee::getName)
        //         .collect(Collectors.toList())
        // ).join();
        // System.out.println("  Custom parallel result: " + customParallelResult);
        
        System.out.println();
    }
    
    // ==================== 6. ADVANCED FEATURES ====================
    public void advancedFeatures() {
        System.out.println("6. ADVANCED FEATURES");
        System.out.println("====================");
        
        // Stream concatenation
        System.out.println("STREAM CONCATENATION:");
        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("D", "E", "F");
        Stream<String> concatenated = Stream.concat(stream1, stream2);
        System.out.println("  " + concatenated.collect(Collectors.toList()));
        
        // Stream builder
        System.out.println("\nSTREAM BUILDER:");
        Stream<String> builtStream = Stream.<String>builder()
            .add("First")
            .add("Second")
            .add("Third")
            .build();
        System.out.println("  " + builtStream.collect(Collectors.toList()));
        
        // Optional with streams
        System.out.println("\nOPTIONAL with STREAMS:");
        Optional<String> optionalName = employees.stream()
            .filter(emp -> emp.getSalary() > 100000)
            .map(Employee::getName)
            .findFirst();
        System.out.println("  High salary employee: " + 
            optionalName.orElse("Not found"));
        
        // Stream with custom collector
        System.out.println("\nCUSTOM COLLECTOR - Employee by department:");
        Map<String, List<Employee>> customGrouped = employees.stream()
            .collect(Collector.of(
                HashMap::new,
                (map, emp) -> map.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp),
                (map1, map2) -> {
                    map2.forEach((key, value) -> 
                        map1.merge(key, value, (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }));
                    return map1;
                }
            ));
        customGrouped.forEach((dept, emps) -> {
            System.out.println("  " + dept + ": " + 
                emps.stream().map(Employee::getName).collect(Collectors.toList()));
        });
        
        // Stream with exception handling
        System.out.println("\nEXCEPTION HANDLING in STREAMS:");
        List<String> safeResults = employees.stream()
            .map(emp -> {
                try {
                    return emp.getName().toUpperCase();
                } catch (Exception e) {
                    return "ERROR";
                }
            })
            .collect(Collectors.toList());
        System.out.println("  " + safeResults);
        
        // Stream with custom comparator
        System.out.println("\nCUSTOM COMPARATOR - Sort by multiple fields:");
        List<Employee> sortedByMultiple = employees.stream()
            .sorted(Comparator
                .comparing(Employee::getDepartment)
                .thenComparing(Employee::getSalary)
                .reversed())
            .collect(Collectors.toList());
        sortedByMultiple.forEach(emp -> 
            System.out.println("  " + emp.getDepartment() + " - " + 
                emp.getName() + " - $" + emp.getSalary()));
        
        System.out.println();
    }
}

// Employee class for examples
class Employee {
    private String name;
    private int age;
    private String department;
    private int salary;
    private String gender;
    
    public Employee(String name, int age, String department, int salary, String gender) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.gender = gender;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public int getSalary() { return salary; }
    public String getGender() { return gender; }
    
    @Override
    public String toString() {
        return name + " (" + department + ", $" + salary + ")";
    }
}
/**

Ran tool
## Key Java 8 Stream Features Covered:

### **1. Stream Creation**
- From collections, arrays, Stream.of(), empty streams
- Infinite streams with iterate() and generate()

### **2. Intermediate Operations**
- `filter()` - Filter elements
- `map()` - Transform elements
- `flatMap()` - Flatten nested collections
- `distinct()` - Remove duplicates
- `sorted()` - Sort elements
- `peek()` - Debug/perform side effects
- `limit()` - Limit elements
- `skip()` - Skip elements
- `takeWhile()` - Take while condition (Java 9+)
- `dropWhile()` - Drop while condition (Java 9+)

### **3. Terminal Operations**
- `forEach()` - Perform action on each element
- `collect()` - Collect to collection
- `toArray()` - Convert to array
- `reduce()` - Reduce to single value
- `min()`/`max()` - Find min/max
- `count()` - Count elements
- `anyMatch()`/`allMatch()`/`noneMatch()` - Match conditions
- `findFirst()`/`findAny()` - Find elements

### **4. Collectors**
- `toList()`/`toSet()`/`toMap()` - Basic collections
- `groupingBy()` - Group elements
- `partitioningBy()` - Partition by condition
- `joining()` - Join strings
- `summarizingInt()` - Get statistics
- `reducing()` - Custom reduction

### **5. Parallel Streams**
- Performance comparison
- Custom thread pools
- Thread safety considerations

### **6. Advanced Features**
- Stream concatenation
- Stream builder
- Optional integration
- Custom collectors
- Exception handling
- Custom comparators

This comprehensive example covers all major Java 8 Stream features with practical, runnable code that you can use for your interview preparation!
**/
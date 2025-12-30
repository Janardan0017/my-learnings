import java.util.*;

public class SimpleComparatorExample {
    public static void main(String[] args) {
        // Simple Integer list
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
        
        System.out.println("Original: " + numbers);
        
        // Natural ordering (ascending)
        Collections.sort(numbers);
        System.out.println("Natural order: " + numbers);
        
        // Custom ordering (descending) using Comparator
        Collections.sort(numbers, (a, b) -> b.compareTo(a));
        System.out.println("Descending: " + numbers);
        
        // Using Collections.reverseOrder()
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Reverse order: " + numbers);
    }
} 
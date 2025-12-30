package interview;

import java.util.Arrays;
import java.util.Random;

/**
 * Comprehensive Sorting Algorithms Demo
 * This class demonstrates various sorting algorithms with detailed comments
 * to help understand how each algorithm works internally.
 */
public class SortingAlgorithmsDemo {

    // =============================================================================
    // 1. BUBBLE SORT
    // Time Complexity: O(n²) worst/average, O(n) best case
    // Space Complexity: O(1)
    // Stable: Yes
    // =============================================================================
    /**
     * Bubble Sort Algorithm:
     * - Repeatedly steps through the list
     * - Compares adjacent elements and swaps them if they're in wrong order
     * - The pass through the list is repeated until no swaps are needed
     * - Called "bubble" because smaller elements "bubble" to the top
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // Outer loop: controls number of passes
        // After each pass, one element is guaranteed to be in correct position
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Flag to optimize - detect if array is already sorted
            
            // Inner loop: compare adjacent elements
            // We go to n-i-1 because last i elements are already sorted after i passes
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap if they're in wrong order
                    swap(arr, j, j + 1);
                    swapped = true; // Mark that a swap occurred
                }
            }
            
            // If no swaps occurred, array is already sorted - optimization
            if (!swapped) {
                System.out.println("Bubble sort: Array sorted early at pass " + (i + 1));
                break;
            }
        }
    }

    // =============================================================================
    // 2. SELECTION SORT
    // Time Complexity: O(n²) all cases
    // Space Complexity: O(1)
    // Stable: No (can be made stable with modifications)
    // =============================================================================
    /**
     * Selection Sort Algorithm:
     * - Divides array into sorted and unsorted portions
     * - Repeatedly finds minimum element from unsorted portion
     * - Places it at the beginning of unsorted portion
     * - Gradually grows the sorted portion
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // Outer loop: position where next minimum should go
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume current position has minimum
            
            // Inner loop: find actual minimum in remaining unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minimum index
                }
            }
            
            // Swap minimum element with element at position i
            // This grows the sorted portion by one element
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    // =============================================================================
    // 3. INSERTION SORT
    // Time Complexity: O(n²) worst/average, O(n) best case
    // Space Complexity: O(1)
    // Stable: Yes
    // =============================================================================
    /**
     * Insertion Sort Algorithm:
     * - Builds final sorted array one element at a time
     * - Takes each element and inserts it into correct position in sorted portion
     * - Like sorting playing cards in your hand
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        // Start from second element (first element is trivially sorted)
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Element to be inserted into sorted portion
            int j = i - 1;    // Start from end of sorted portion
            
            // Move elements greater than key one position ahead
            // This creates space for key to be inserted
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift element to right
                j--;
            }
            
            // Insert key at correct position
            arr[j + 1] = key;
        }
    }

    // =============================================================================
    // 4. MERGE SORT
    // Time Complexity: O(n log n) all cases
    // Space Complexity: O(n)
    // Stable: Yes
    // =============================================================================
    /**
     * Merge Sort Algorithm:
     * - Divide and Conquer approach
     * - Recursively divides array into halves until single elements
     * - Then merges them back in sorted order
     */
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        mergeSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void mergeSortHelper(int[] arr, int left, int right) {
        // Base case: if left >= right, subarray has 0 or 1 element
        if (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            
            // Recursively sort left half
            mergeSortHelper(arr, left, mid);
            
            // Recursively sort right half
            mergeSortHelper(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * Merges two sorted subarrays: arr[left...mid] and arr[mid+1...right]
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Create temporary arrays for left and right subarrays
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];
        
        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArr, 0, leftArr.length);
        System.arraycopy(arr, mid + 1, rightArr, 0, rightArr.length);
        
        // Merge the temporary arrays back into arr[left...right]
        int i = 0, j = 0, k = left;
        
        // Compare elements from both arrays and merge in sorted order
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        // Copy remaining elements (if any)
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // =============================================================================
    // 5. QUICK SORT
    // Time Complexity: O(n log n) average, O(n²) worst case
    // Space Complexity: O(log n) average, O(n) worst case
    // Stable: No
    // =============================================================================
    /**
     * Quick Sort Algorithm:
     * - Divide and Conquer approach
     * - Picks a pivot element and partitions array around it
     * - Elements smaller than pivot go to left, larger to right
     * - Recursively sorts the partitions
     */
    public static void quickSort(int[] arr) {
        if (arr.length <= 1) return;
        quickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * Partitions array around pivot (last element)
     * Returns index of pivot after partitioning
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1;       // Index of smaller element
        
        // Traverse through array
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // Increment index of smaller element
                swap(arr, i, j);
            }
        }
        
        // Place pivot in correct position
        swap(arr, i + 1, high);
        return i + 1; // Return pivot index
    }

    // =============================================================================
    // 6. HEAP SORT
    // Time Complexity: O(n log n) all cases
    // Space Complexity: O(1)
    // Stable: No
    // =============================================================================
    /**
     * Heap Sort Algorithm:
     * - Uses binary heap data structure
     * - First builds max heap from array
     * - Repeatedly extracts maximum element and places at end
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap (rearrange array)
        // Start from last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum) to end
            swap(arr, 0, i);
            
            // Call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }
    
    /**
     * Maintains heap property for subtree rooted at index i
     * n is size of heap
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2; // Right child
        
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            
            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // =============================================================================
    // 7. COUNTING SORT
    // Time Complexity: O(n + k) where k is range of input
    // Space Complexity: O(k)
    // Stable: Yes
    // =============================================================================
    /**
     * Counting Sort Algorithm:
     * - Non-comparison based sorting
     * - Counts frequency of each element
     * - Uses count array to determine position of each element
     * - Only works for integers with known range
     */
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;
        
        // Find range of input
        int max = Arrays.stream(arr).max().orElse(0);
        int min = Arrays.stream(arr).min().orElse(0);
        int range = max - min + 1;
        
        // Create count array and output array
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // Count frequency of each element
        for (int value : arr) {
            count[value - min]++;
        }
        
        // Modify count array to store actual positions
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array using count array
        // Process from right to left to maintain stability
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        // Copy output array back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // =============================================================================
    // 8. RADIX SORT
    // Time Complexity: O(d × (n + k)) where d is digits, k is range
    // Space Complexity: O(n + k)
    // Stable: Yes
    // =============================================================================
    /**
     * Radix Sort Algorithm:
     * - Non-comparison based sorting
     * - Sorts by individual digits/characters
     * - Uses counting sort as subroutine for each digit
     * - Processes digits from least significant to most significant
     */
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;
        
        // Find maximum number to determine number of digits
        int max = Arrays.stream(arr).max().orElse(0);
        
        // Do counting sort for every digit
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
    
    /**
     * Counting sort based on digit represented by exp
     */
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // For digits 0-9
        
        // Count frequency of each digit
        for (int value : arr) {
            count[(value / exp) % 10]++;
        }
        
        // Change count[i] to actual position of digit in output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        // Copy output array back to arr
        System.arraycopy(output, 0, arr, 0, n);
    }

    // =============================================================================
    // UTILITY METHODS
    // =============================================================================
    
    /**
     * Swaps two elements in array
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Prints array with label
     */
    private static void printArray(String label, int[] arr) {
        System.out.println(label + Arrays.toString(arr));
    }
    
    /**
     * Creates copy of array for testing
     */
    private static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }

    // =============================================================================
    // MAIN METHOD - DEMONSTRATION
    // =============================================================================
    public static void main(String[] args) {
        // Test data
        int[] original = {64, 34, 25, 12, 22, 11, 90, 5, 77, 30};
        
        System.out.println("=".repeat(80));
        System.out.println("SORTING ALGORITHMS DEMONSTRATION");
        System.out.println("=".repeat(80));
        printArray("Original Array: ", original);
        System.out.println();

        // Test each sorting algorithm
        testSortingAlgorithm("BUBBLE SORT", original, SortingAlgorithmsDemo::bubbleSort);
        testSortingAlgorithm("SELECTION SORT", original, SortingAlgorithmsDemo::selectionSort);
        testSortingAlgorithm("INSERTION SORT", original, SortingAlgorithmsDemo::insertionSort);
        testSortingAlgorithm("MERGE SORT", original, SortingAlgorithmsDemo::mergeSort);
        testSortingAlgorithm("QUICK SORT", original, SortingAlgorithmsDemo::quickSort);
        testSortingAlgorithm("HEAP SORT", original, SortingAlgorithmsDemo::heapSort);
        testSortingAlgorithm("COUNTING SORT", original, SortingAlgorithmsDemo::countingSort);
        testSortingAlgorithm("RADIX SORT", original, SortingAlgorithmsDemo::radixSort);
        
        // Performance comparison with larger dataset
        System.out.println("\n" + "=".repeat(80));
        System.out.println("PERFORMANCE COMPARISON (1000 random elements)");
        System.out.println("=".repeat(80));
        performanceTest();
    }
    
    /**
     * Tests a sorting algorithm and measures time
     */
    private static void testSortingAlgorithm(String name, int[] original, java.util.function.Consumer<int[]> sortFunction) {
        int[] arr = copyArray(original);
        
        System.out.println("-".repeat(40));
        System.out.println(name);
        System.out.println("-".repeat(40));
        
        long startTime = System.nanoTime();
        sortFunction.accept(arr);
        long endTime = System.nanoTime();
        
        printArray("Sorted:   ", arr);
        System.out.printf("Time:     %.3f ms%n", (endTime - startTime) / 1_000_000.0);
        System.out.println("Correct:  " + isSorted(arr));
        System.out.println();
    }
    
    /**
     * Checks if array is sorted
     */
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
    
    /**
     * Performance test with larger dataset
     */
    private static void performanceTest() {
        int size = 1000;
        Random rand = new Random(42); // Fixed seed for reproducible results
        
        // Create random array
        int[] original = new int[size];
        for (int i = 0; i < size; i++) {
            original[i] = rand.nextInt(1000);
        }
        
        // Test algorithms (excluding slow ones for large data)
        String[] algorithms = {"Merge Sort", "Quick Sort", "Heap Sort", "Counting Sort", "Radix Sort"};
        // java.util.function.Consumer<int[]>[] functions = new java.util.function.Consumer<int[]>[]{
        //     SortingAlgorithmsDemo::mergeSort, // Ensure this matches the correct signature
        //     SortingAlgorithmsDemo::quickSort,
        //     SortingAlgorithmsDemo::heapSort,
        //     SortingAlgorithmsDemo::countingSort,
        //     SortingAlgorithmsDemo::radixSort
        // };
        
        for (int i = 0; i < algorithms.length; i++) {
            int[] arr = copyArray(original);
            
            long startTime = System.nanoTime();
            // functions[i].accept(arr);
            long endTime = System.nanoTime();
            
            System.out.printf("%-15s: %8.3f ms (Correct: %s)%n", 
                algorithms[i], 
                (endTime - startTime) / 1_000_000.0,
                isSorted(arr) ? "✓" : "✗"
            );
        }
        
        System.out.println("\nNote: Bubble, Selection, and Insertion sorts are O(n²) and too slow for 1000 elements demo.");
    }
} 
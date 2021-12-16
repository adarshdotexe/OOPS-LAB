package Lab1.Searching;

public class LinearSearch {
    public static void main(String[] args) {
        // Hard Coding the Array (Sorted/Unsorted) and Key
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int key = 50;
        int n = arr.length;

        // Print Array to Console
        System.out.println("The given array (sorted/unsorted) is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Linear Search
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println(key + " found. It is at index: " + i);
                return;
            }
        }
        System.out.println(key + " NOT found.");
        return;
    }
}

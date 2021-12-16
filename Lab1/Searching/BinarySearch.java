package Lab1.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        // Hard Coded Array (sorted) & Key
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int key = 50;
        int first = 0;
        int last = arr.length - 1;

        // Print Array to Console
        System.out.println("The given array (sorted) is: ");
        for (int i = 0; i <= last; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Binary Search
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                System.out.println(key + " found. It is at index: " + mid);
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println(key + " NOT found.");
        }
        return;
    }
}

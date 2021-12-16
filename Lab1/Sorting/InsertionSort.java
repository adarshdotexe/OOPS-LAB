package Lab1.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        // Hard Coding the Array (Unsorted)
        int[] arr = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
        int n = arr.length;

        // Print Array to Console
        System.out.println("The given array (unsorted) is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        System.out.println("The array after sorting is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }
}

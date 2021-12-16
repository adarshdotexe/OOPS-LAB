package Lab1.Sorting;

public class BubbleSort {
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

        // Bubble Sort
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    // Swap
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        System.out.println("The array after sorting is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }
}

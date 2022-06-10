package dataStructures.arrays;

import static dataStructures.arrays.ArrayUtils.printArray;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5};

        System.out.println("Reverse an Array: " );

        reverseArray(arr);
        printArray(arr);
    }

    private static void reverseArray(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n/2; i++){     // traverse upto n/2
            swap(arr, i, n-1-i);
        }
    }

    private static void swap(int arr[],int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

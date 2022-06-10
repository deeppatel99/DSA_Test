package algorithms_AND_BinarySearch.sorting_algorithms;

import static dataStructures.arrays.ArrayUtils.printArray;

public class Bubble_Sort {
    public static void main(String[] args) {
        int arr[] = { 5, 3, 1, 7, 4};

        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

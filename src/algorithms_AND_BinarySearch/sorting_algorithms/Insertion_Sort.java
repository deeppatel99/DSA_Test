package algorithms_AND_BinarySearch.sorting_algorithms;

import static dataStructures.arrays.ArrayUtils.printArray;

public class Insertion_Sort {
    public static void main(String[] args) {
        int arr[] = {5, 4, 4, 3, 2, 1};

        insertionSort(arr);
        printArray(arr);
    }

    private static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;
        }
    }
}

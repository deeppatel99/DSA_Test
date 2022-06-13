package algorithms_AND_BinarySearch.sorting_algorithms;

import static dataStructures.arrays.ArrayUtils.printArray;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 2, 5, 7, 9, 1, 3};

        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int l, int h) {
        if(l < h){
            int pivot = partition(arr, l, h);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        int j = h;

        while (i < j){
            while (arr[i] <= pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if(i < j)
                swap(arr, i , j);
        }

        swap(arr, j, l);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

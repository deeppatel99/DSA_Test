package algorithms_AND_BinarySearch.BinarySearchAlgorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        search(arr, 4);
    }

    private static void search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;

        while (left <= right){
            int mid = left + (right - left)/2;

            if(arr[mid] == target) {
                index = mid;
                break;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        if(index != -1){
            System.out.println(target + " found at index : " + index);
        }else {
            System.out.println(target + " not found");
        }
    }
}

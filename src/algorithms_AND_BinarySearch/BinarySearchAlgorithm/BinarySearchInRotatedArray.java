package algorithms_AND_BinarySearch.BinarySearchAlgorithm;

public class BinarySearchInRotatedArray {
    public static void main(String[] args) {
        int arr[] = {11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        search(arr, 6);
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
            }

            if(arr[left] <= arr[mid]){
                if(arr[left] <= target && target <= arr[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }

            }else {
                if(arr[mid] <= target && target <= arr[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        if(index != -1){
            System.out.println(target + " found at index : " + index);
        }else {
            System.out.println(target + " not found");
        }
    }
}

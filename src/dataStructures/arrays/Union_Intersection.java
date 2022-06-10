package dataStructures.arrays;

public class Union_Intersection {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 8};
        int arr2[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};


        // union
        printUnion(arr1, arr2);

        System.out.println();
        // intersection
        printIntersection(arr1, arr2);
    }

    private static void printIntersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        while (i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
//                System.out.print(arr1[i] + " ");
                i++;
            }else if(arr1[i] > arr2[j]){
//                System.out.print(arr2[j] + " ");
                j++;
            }else{
                int temp = arr1[i];
                    System.out.print(arr1[i] + " ");

                while( i < n1 && arr1[i] == temp){
                    i++;
                }

                while (j < n2 && arr2[j] == temp){
//                    System.out.print(arr2[j] + " ");
                    j++;
                }
            }
        }
    }

    private static void printUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        while (i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
            }else if(arr1[i] > arr2[j]){
                System.out.print(arr2[j] + " ");
                j++;
            }else{
                int temp = arr1[i];

                while( i < n1 && arr1[i] == temp){
                    System.out.print(arr1[i] + " ");
                    i++;
                }

                while (j < n2 && arr2[j] == temp){
                    System.out.print(arr2[j] + " ");
                    j++;
                }
            }
        }
    }
}

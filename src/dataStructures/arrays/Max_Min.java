package dataStructures.arrays;

public class Max_Min {
    public static void main(String[] args) {
        int arr[] = {15, 15, 1, 2, 3, 4, 5, 9, 13};
        int arr2[] = new int[] {1, 2, 2, 3};



        secondUniqueMaximum(arr);
        secondMaximum(arr);
        secondUniqueMaximum(arr2);
    }

    private static void secondUniqueMaximum(int[] arr) {
        int current_Max = Integer.MIN_VALUE;
        int second_current_Max = Integer.MIN_VALUE;

        for(int x: arr){
            if(x > current_Max){
                second_current_Max = current_Max;
                current_Max = x;
            }else if( x > second_current_Max && x != current_Max){
                second_current_Max = x;
            }
        }

        System.out.println("Second Unique Maximum : " + second_current_Max);
    }

    private static void secondMaximum(int[] arr) {
        int current_Max = Integer.MIN_VALUE;
        int second_current_Max = Integer.MIN_VALUE;

        for(int x: arr){
            if(x > current_Max){
                second_current_Max = current_Max;
                current_Max = x;
            }else if( x > second_current_Max && second_current_Max < current_Max){
                second_current_Max = x;
            }
        }

        System.out.println("Second Maximum : " + second_current_Max);
    }
}

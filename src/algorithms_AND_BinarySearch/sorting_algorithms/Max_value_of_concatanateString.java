package algorithms_AND_BinarySearch.sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Max_value_of_concatanateString {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();

        str.add("1");
        str.add("50");
        str.add("19");

        Collections.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        for (String s :
                str) {
            System.out.print( " " + s);
//            System.out.println();
        }
    }
}

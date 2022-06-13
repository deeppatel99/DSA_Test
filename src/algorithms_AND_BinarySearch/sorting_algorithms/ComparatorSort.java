package algorithms_AND_BinarySearch.sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Sourav", 70, 85));
        students.add(new Student("Abhishek", 71, 85));
        students.add(new Student("Amit", 72, 87));

//        Collections.sort(students,(s1, s2) -> s1.averageMark - s2.averageMark);      // Increasing order
//        Collections.sort(students,(s1, s2) -> s2.averageMark - s1.averageMark);    // Decreasing order

        // If avgMarks are same then it'll follow by name property
        Collections.sort(students,(s1, s2) -> s1.averageMark != s2.averageMark ? s1.averageMark - s2.averageMark : s1.name.compareTo(s2.name));

        for (Student s :
                students) {
            System.out.print(s.name + " " + s.averageMark + " " + s.rollNumber + "\n");
        }
    }
}


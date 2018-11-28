package JavaBasics;

import util.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaGenericsDemo {

    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;

         if(y.compareTo(max) > 0)
             max = y;

         if(z.compareTo(max) > 0)
             max = z;

         return max;
    }

    public static void basicTest(){
        System.out.println("Running basic test...");
        System.out.println(maximum(3,4,5));
        System.out.println(maximum(3.3,4.4,5.5));
        System.out.println(maximum('a','b','c'));
    }

    public static void runStudentTest(){
        Student s1 = new Student("Andy", 24, 3.5);
        Student s2 = new Student("Bob", 23, 3.6);
        Student s3 = new Student("Cathy", 22, 3.7);

        System.out.println("Maximum: "+maximum(s1, s2, s3));

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        Sorter.staticSortDataList(studentList, new StudentAgeComparator());
        Printer.printList(studentList);

        Sorter.staticSortDataList(studentList, new StudentGPAComparator());
        Printer.printList(studentList);

        Sorter<Student> studentSorter = new Sorter<>();
        studentSorter.nonStaticSortDataList(studentList, new StudentAgeComparator());
        Printer.printList(studentList);
    }

    public static void main(String[] args) {
//        basicTest();
        runStudentTest();
    }
}

class Sorter<T> {
    public static <T extends Comparable<T>> void staticSortDataList(List<T> rows, Comparator<T> comparator){
        Collections.sort(rows, comparator);
    }

    public <T> void nonStaticSortDataList(List<T> rows, Comparator<T> comparator){
        Collections.sort(rows, comparator);
    }

}



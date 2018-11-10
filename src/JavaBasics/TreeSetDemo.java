package JavaBasics;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet is basically implementation of a self-balancing binary search tree like Red-Black Tree.
 * Review: Therefore operations like add, remove and search take  O(Log n)  time.
 * And operations like printing n elements in sorted order takes O(n) time.
 */
public class TreeSetDemo {
    public static void demo1(){
        TreeSet<String> ts1 = new TreeSet();

        String[] strArr = {"A", "B", "C"};

        // Elements are added using add() method
        for(String s : strArr){
            System.out.println("Inserting "+s);
            ts1.add(s);
            System.out.println("TreeSet size = "+ts1.size());
        }
        // Duplicates will not get insert
        System.out.println("Inserting "+strArr[strArr.length-1]);
        ts1.add(strArr[strArr.length-1]);
        System.out.println("TreeSet size = "+ts1.size());

        System.out.println("Removing "+strArr[strArr.length-1]);
        ts1.remove(strArr[strArr.length-1]);
        System.out.println("TreeSet size = "+ts1.size());

        // Elements get stored in default natural
        // Sorting Order(Ascending)
        System.out.println("Print out the TreeSet (in default order):");
        System.out.println(ts1);
    }

    public static void demo2(){
        TreeSet<String> ts1 = new TreeSet(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str2.compareTo(str1);
            }
        });

        String[] strArr = {"A", "B", "C"};

        // Elements are added using add() method
        for(String s : strArr){
            System.out.println("Inserting "+s);
            ts1.add(s);
            System.out.println("TreeSet size = "+ts1.size());
        }

        System.out.println("First of the TreeSet: "+ts1.first());
        System.out.println("Last of the TreeSet: "+ts1.last());

        System.out.println("Print out the TreeSet (in reversed order):");
        System.out.println(ts1);
    }

    public static void demo3(){
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i1 > i2 ? -1 : 1;
            }
        });

        ts.add(1);
        ts.add(2);
        ts.add(4);
        ts.add(8);

        System.out.println("Elements in the TreeSet: "+ts);

        System.out.println("ts.ceiling(3) = "+ts.ceiling(3));

        System.out.println("ts.floor(5) = "+ts.floor(5));
    }

    public static void main(String[] args) {
        demo3();
    }
}

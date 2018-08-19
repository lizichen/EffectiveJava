package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {


    public static void testBasicPriorityQueue(){

        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        // Review: is equivalent to :
//        Comparator<String> stringLengthComparator = (s1, s2) -> {
//            return s1.length() - s2.length();
//        };

        // Review: is equivalent to :
        //    Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);


        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(stringLengthComparator);

        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("John");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");

        // Remove items from the Priority Queue (DEQUEUE)
        while (!namePriorityQueue.isEmpty()) {
            System.out.println(namePriorityQueue.remove());
        }
    }

    // PriorityQueue only takes Comparable Objects
    public static void testComparableEmployee(){
        PriorityQueue<ComparableEmployee> employeePriorityQueue = new PriorityQueue<ComparableEmployee>();

        employeePriorityQueue.add(new ComparableEmployee("Rajeev", 100000.00));
        employeePriorityQueue.add(new ComparableEmployee("Chris", 145000.00));
        employeePriorityQueue.add(new ComparableEmployee("Andrea", 115000.00));
        employeePriorityQueue.add(new ComparableEmployee("Jack", 167000.00));

        while(!employeePriorityQueue.isEmpty()){
            System.out.println(employeePriorityQueue.remove());
        }
    }

    public static void main(String[] args){
        testComparableEmployee();
    }
}


package util;

import java.math.BigInteger;
import java.util.*;
import java.util.Arrays;

/**
 * Created by lizichen on 1/19/18.
 */
public class TestClass {

    public static void testHashtable(){
        HashMap table = new HashMap();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
    }

    public static void testListConversion(){
        int[] newArr = {1,2,3,4,5};
        List list = Arrays.asList(newArr);
        try{
            list.add(new Integer(1));
        }catch (Exception e){
            System.out.println("UnsupportedOperationException!");
        }
    }

    public static void testHashSetAddReturnValue(){
        HashSet set = new HashSet();
        System.out.println(set.add('I'));
        System.out.println(set.add('K'));
        System.out.println(set.add('I'));
    }

    public static void testHashMapGetOrDefault(){
        HashMap table = new HashMap();
        System.out.println(table.put("key1", 1));
        System.out.println(table.put("key2", 2));
        System.out.println(table.getOrDefault("key1", -1));
        System.out.println(table.getOrDefault("key2", -2));
        System.out.println(table.getOrDefault("key3", -1));
    }

    public static void testHashSetAddObject(){
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(1, 2, 3);

        HashSet<List<Integer>> set = new HashSet<>();
        System.out.println(set.add(l1));
        System.out.println(set.add(l2));
    }

    public static void main(String[] args) {
        BigInteger t = new BigInteger("26");
        System.out.println(t.pow(2));

        t = t.add(new BigInteger("2"));
        System.out.println(t.toString());

    }


}

package util;

import Tree.TreeNode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

    public static void testUseOfBigInteger(){
        BigInteger t = new BigInteger("26");
        System.out.println(t.pow(2));

        t = t.add(new BigInteger("2"));
        System.out.println(t.toString());
    }

    public static void testHashMapComputeIfFunctions(){
        Map<String, Integer> map = new HashMap<>();

        System.out.println("computeIfAbsent...");

        map.computeIfAbsent("snoop", k -> k.length());
        System.out.println(map.get("snoop"));

        System.out.println("computeIfPresent...");

        map.computeIfPresent("snoop", (k,v) -> v+1);
        System.out.println(map.get("snoop"));
    }

    public static void testJavaReflection(){
        int tree_val = 1;

        TreeNode node1 = new TreeNode(tree_val);

        /* Example of Java Reflection: */
        Class treenodeClassDefinition = null;
        try {
            treenodeClassDefinition = Class.forName("TreeNode"); // TODO: use custom ClassLoader
            Class[] treeNodeArgClass = new Class[]{Integer.class};
            Object[] intArg = new Object[]{tree_val};

            Constructor treenodeConstructor = treenodeClassDefinition.getConstructor(treeNodeArgClass);
            TreeNode node2 = (TreeNode)treenodeConstructor.newInstance(intArg);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // Given a list check if any continuous digits adds up to sum
    public static int checkAndCount(List<Integer> res, int sum){
        int count = 0;
        for(int i=res.size() - 1; i>=1; i--){
            int tmpSum = sum - res.get(i);
            int found = 0; // you may find more than one subset of numbers that's good!
            for(int j=i-1; j>=0; j--){
                tmpSum -= res.get(j);
                if(tmpSum == 0){
                    found++;
                }
            }
            count += found;
        }
        return count;
    }

    public static void main(String[] args) {


    }


}

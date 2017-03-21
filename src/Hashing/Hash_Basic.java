package Hashing;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by lizichen1 on 11/5/16.
 */
public class Hash_Basic {
    /**
     * Java Map interface are implemented by:
     *      HashMap, HashTable, TreeHashMap, LinkedHashMap
     *
     *
         [HashMap]	                            [HashTable]
         Introduced at Java 1.2	                Introduced in the very beginning
         Not thread safe and unsynchronized	    It is thread safe and is synchronized
         Fast	                                Slow
         Works with single thread	            Works with multiple threads
         Allows one null key	                Does not allow null key
     *
     */

    public static void HashTable_Examples(){
        Hashtable table = new Hashtable();
        table.put("Zinc", new Double(7323.45));
        table.put("Zack", new Double(5123.23));
        table.put("Zoom", new Double(3223.15));

        Enumeration keys = table.keys();
        while(keys.hasMoreElements()){
            String key = (String) keys.nextElement();
            System.out.println("name: "+key+" acct bal: "+table.get(key));
        }
    }

    public static void HashMap_Examples(){
        Map phonebook = new HashMap<String, String>();
        phonebook.put("Luke", "1234567890");
        phonebook.put("Mike", "2345678901");
        phonebook.put("Duke", "3456789012");

        Boolean containsAKey = phonebook.containsKey("aKey");
        System.out.println("containsKey = " + containsAKey);

        Set<String> setOfNames = phonebook.keySet();
        for (String s:setOfNames) {
            System.out.println(s+" "+phonebook.get(s));
        }

        Set<Map.Entry<String, String>> phonebookitem = phonebook.entrySet();
        for(Map.Entry<String, String> i:phonebookitem){
            System.out.println(i.getKey()+" "+i.getValue());
        }
    }

    public static void HashSet_Examples(){
        HashSet set = new HashSet();
        set.clear(); /// remove all elements from the set

        Boolean _add_ = set.add("a");
        System.out.println(_add_);
        System.out.println(set.add("a"));

        Boolean _contains_ = set.contains("an object");

        Boolean _isEmpty_ = set.isEmpty();

        int _size_ = set.size();

        Iterator iter = set.iterator();
        while(iter.hasNext()){
            Object someobj = iter.next();
        }
    }

    public static void main(String[] args){
        HashSet_Examples();
    }
}


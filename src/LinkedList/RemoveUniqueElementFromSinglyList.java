package LinkedList;

import util.Printer;

import static LinkedList.ListNode.buildSinglyLinkedListFromIntArray;

/**
 * Created by lizichen1 on 9/26/16.
 *
 * FA Course by A. Siegel
 * Ex. 2.20
 *
 */
public class RemoveUniqueElementFromSinglyList {

    private final static int CLEAN_VALUE = 1;
    private final static int CLEAN_VALUE_2 = 0;

    public static void main(String[] args) {
        int[] arr = {1,2,0,4,1,0,2,6,0,8,1,9,0,0,10};
        ListNode a = buildSinglyLinkedListFromIntArray(arr);
        System.out.println(Printer.printIntArrayToString(arr));
        System.out.println("Iterative Clean: ");
        ListNode c = iterativeClean(a);
        while(c !=null){
            System.out.print(c.val+" ");
            c = c.next;
        }
        System.out.println("\nRecursive Clean: ");
        ListNode b = recursiveClean(a);
        while(b !=null){
            System.out.print(b.val+" ");
            b = b.next;
        }
    }

    public static ListNode recursiveClean(ListNode a){
        if(a.next == null)
            if (a.val == CLEAN_VALUE_2)
                a = null;
            else
                return a;
        else
            if (a.val == CLEAN_VALUE_2)
                return recursiveClean(a.next);
            else
                a.next = recursiveClean(a.next);
        return a;
    }

    public static ListNode iterativeClean(ListNode a){
        if(a == null || a.next == null)
            return a;
        else{
            if(a.getValue() == CLEAN_VALUE) {
                a = a.getNext();
            }
            ListNode cursor = a; // because this cannot eliminate the first element, we have to add the above if evaluation.
            ListNode previousCursor = null;
            while(cursor!=null){
                if(cursor.getValue() == CLEAN_VALUE){
                    previousCursor.setNext(cursor.getNext());
                    cursor = cursor.getNext();
                }
                else{
                    previousCursor = cursor;
                    cursor = cursor.getNext();
                }
            }
            return a;
        }
    }



}

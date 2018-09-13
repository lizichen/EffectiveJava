package LinkedList;

/**
 * Created by lizichen1 on 9/26/16.
 */
public class ListNode {

    protected int val;
    protected ListNode next;

    public ListNode(int value){
        this.val = value;
        this.next = null;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode buildSinglyLinkedListFromIntArray(int[] arr){
        ListNode testroot = new ListNode(arr[0]);
        ListNode cursor = testroot;
        for(int i=1;i<arr.length;i++){
            ListNode newNode = new ListNode(arr[i]);
            cursor.next = newNode;
            cursor = newNode;
        }
        return testroot;
    }

    public static void printListNode(ListNode head){
        ListNode tmp = head;
        StringBuilder sb = new StringBuilder("");
        while(tmp != null){
            sb.append(tmp.val+" -> ");
            tmp = tmp.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

}

package LinkedList;

/**
 * Created by lizichen1 on 9/26/16.
 */
public class SinglyListNode {

    protected int val;
    protected SinglyListNode next;

    public SinglyListNode(int value){
        this.val = value;
        this.next = null;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public SinglyListNode getNext() {
        return next;
    }

    public void setNext(SinglyListNode next) {
        this.next = next;
    }

}

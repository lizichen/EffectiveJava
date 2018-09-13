package LinkedList;

/**
 * Created by lizichen1 on 9/28/16.
 */
public class SortedSinglyList {

    ListNode head;
    int size;


    public SortedSinglyList(){
        this.head = null;
        this.size = 0;
    }

    public SortedSinglyList(ListNode head){
        this.head = head;
        this.size = 1;
    }

    /**
     * Default sorting: head has the largest value.
     */
    public void push(ListNode newNode){
        if(head == null){
            head = newNode;
        }
        else if(newNode.getValue() > head.getValue()){
            ListNode tmp = head.getNext();
            head = newNode;
            newNode.setNext(tmp);
        }
        else{
            ListNode cursor = head;
            while(cursor!=null){
                if(newNode.getValue() <= cursor.getValue()){ // this if statement is actually redundent
                    if(cursor.getNext() == null){
                        cursor.setNext(newNode);
                        break;
                    }
                    else if(newNode.getValue() > cursor.getNext().getValue()){
                        ListNode tmp = cursor.getNext();
                        cursor.setNext(newNode);
                        newNode.setNext(tmp);
                        break;
                    }
                    else{
                        cursor = cursor.getNext();
                    }
                }
            }
        }
        size++;
    }

    /**
     * default pop from the head to tail
     */
    public ListNode pop(){
        if(this.head == null){
            return null;
        }
        else{
            ListNode popHead = head;
            head = head.getNext();
            size--;
            return popHead;
        }
    }

    public int getSize(){
        return this.size;
    }


    public void push(int newNodeValue){
        ListNode node = new ListNode(newNodeValue);
        push(node);
    }

    public void reverse(){

    }

    public String toStringAll(){

        return "";
    }
}

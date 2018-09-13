package LinkedList;

/**
 * Created by lizichen1 on 9/25/16.
 */
public class SinglyLinkedListStack {

    private ListNode root;

    public SinglyLinkedListStack(){
        root = null;
    }

    private void push(int newValue){
        ListNode newNode = new ListNode(newValue);
        if(this.root == null) {
            this.root = newNode;
        }else{
            newNode.setNext(root);
            this.root = newNode;
        }
    }

    private int pop(){

        if(this.root == null){
            throw new LinkedListEmptyException();
        }
        int rootValue = this.root.getValue();
        this.root = root.getNext();
        return rootValue;
    }
}

class LinkedListEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public LinkedListEmptyException() {
        super();
    }

    public LinkedListEmptyException(String message) {
        super(message);
    }
}

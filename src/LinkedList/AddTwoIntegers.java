package LinkedList;

/**
 * Created by lizichen1 on 10/31/16.
 *
 * Given head pointers of two linked list where each linked list represents an integer number (each node is a digit), add them and return resulting linked list.
 */
public class AddTwoIntegers {

    private ListNode firstHead;
    private ListNode secondHead;

    public AddTwoIntegers(int firstInt, int secondInt){
        String temp = Integer.toString(firstInt);
        int[] firstArr = new int[temp.length()];
        int length = temp.length();
        for(int i=0;i<length;i++){
            firstArr[i] = firstInt%10;
            firstInt = firstInt/10;
        }
        temp = Integer.toString(secondInt);
        int[] secondArr = new int[temp.length()];
        length = temp.length();
        for(int i=0;i<temp.length();i++){
            secondArr[i] = secondInt % 10;
            secondInt /= 10;
        }
        this.firstHead = ListNode.buildSinglyLinkedListFromIntArray(firstArr);
        this.secondHead = ListNode.buildSinglyLinkedListFromIntArray(secondArr);
    }

    public ListNode computer(){

        ListNode result = add();
        // TODO:
        // multiply
        // divide
        // binary? hex?
        return ReverseSinglyLinkedList.reverseSinglyLinkedList(result); // reverse the result list.
    }

    public ListNode add(){
        int carry = 0;
        ListNode resultNode = null;
        ListNode cursor = null;
        int resultDigit = 0;

        if(firstHead == null)
            return secondHead == null ? null : secondHead;
        else if(secondHead == null)
            return null;
        while(firstHead!=null || secondHead!=null || carry > 0){
            int firstVal = firstHead == null ? 0 : firstHead.getValue();
            int secondVal = secondHead == null ? 0 : secondHead.getValue();

            resultDigit = firstVal + secondVal + carry;
            // PAY ATTENTION TO CLEARING OUT THE CARRIED DIGIT! - carry
            ListNode newValNode = new ListNode( resultDigit % 10 );
            carry = resultDigit / 10;

            if(resultNode == null){
                resultNode = newValNode;
            }
            else{
                cursor.setNext(newValNode);
            }
            cursor = newValNode;
            // IF the any of the head is NULL, it remains NULL.
            firstHead = (firstHead!=null) ? firstHead.getNext() : null;
            secondHead = (secondHead!=null) ? secondHead.getNext() : null;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        int int1 = 291;
        int int2 = 319;
        AddTwoIntegers addTwoIntegers = new AddTwoIntegers(int1, int2);
        System.out.print(int1 + " + " + int2 + " = ");
        ListNode resultHead = addTwoIntegers.computer();

        while (resultHead!=null){
            System.out.print(resultHead.getValue());
            resultHead = resultHead.getNext();
        }
    }
}

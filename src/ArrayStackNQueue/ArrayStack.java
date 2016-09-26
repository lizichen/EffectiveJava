package ArrayStackNQueue;
/**
 * Use array to implement a stack.
 * http://www.java2blog.com/2016/09/implement-stack-using-array-in-java.html
 */
public class ArrayStack {

    private int top;
    private int[] arr;
    private int size;

    public ArrayStack(int size){
        this.top = -1;
        this.arr = new int[size];
        this.size = size;
    }

    public int pop(){
        int popValue = this.peek();
        if(top > 0) top--;
        else
            System.out.println("Stack is empty!");
        return popValue;
    }

    public void push(int newValue){
        if(top + 1 < size){
            arr[++top] = newValue;
        }else{
            System.out.println("Stack is full!"); // maybe resize the arr to size*2
        }
    }

    public int peek(){
        int returnValue=0;
        if(top > 0)
            returnValue = arr[top];
        else
            System.out.println("Stack is empty!");
        return returnValue;
    }

    public void printStack(){
        for(int i=top; i>=0; i--){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.printStack();
        System.out.println("Pop:"+arrayStack.pop());
        arrayStack.printStack();
    }
}

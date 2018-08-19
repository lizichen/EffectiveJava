package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lizichen1 on 7/31/18.
 */
public class MovingAverageFromDataStream_346 {

    int counter = 0;
    int size = 0;
    // 1.  only used in next()
    Queue<Integer> queue = new LinkedList<>();

    // 2. used in next2 and next3
    double totalAmount = 0;

    // 3. only used in next3
    int[] arr;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream_346(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public double next(int val) {
        if(this.counter < this.size){
            queue.add(val);
            this.counter++;
        }else{
            queue.remove(); // remove head of the queue;
            queue.add(val);
        }

        return sumQueue()/this.counter;
    }

    public double sumQueue(){
        int sum = 0;
        for(Integer i: this.queue){
            sum += i;
        }
        return sum;
    }

    // version 2
    public double next2(int val) {
        if(this.counter < this.size){
            queue.add(val);
            totalAmount += val;
            this.counter++;
        }else{
            totalAmount -= queue.remove();
            totalAmount += val;
            queue.add(val);
        }

        return totalAmount/this.counter;
    }

    // version 3
    public double next3(int val){
        int index = this.counter % this.size;
        this.totalAmount -= this.arr[index];
        this.totalAmount += val;
        this.arr[index] = val;

        this.counter++;

        return this.totalAmount/(this.counter < this.size ? this.counter : this.size);
    }

    public static void main(String[] args) {
        MovingAverageFromDataStream_346 m = new MovingAverageFromDataStream_346(3);
        System.out.println(m.next3(1)) ;  //= 1
        System.out.println(m.next3(10)) ;//= (1 + 10) / 2
        System.out.println(m.next3(3))  ;//= (1 + 10 + 3) / 3
        System.out.println(m.next3(5))  ;//= (10 + 3 + 5) / 3

    }
}

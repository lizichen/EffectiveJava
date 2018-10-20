package InterviewQuiz;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Bloomberg_FunctionClicks {

    Queue<Long> timeQueue = new LinkedList<>();

    public int click(){
        long currentTimeInSecond = System.currentTimeMillis();
        this.timeQueue.add(currentTimeInSecond);

        long queueHeadTime = timeQueue.peek();

        while(!within3Seconds(queueHeadTime, currentTimeInSecond)){
            System.out.println("polling out "+this.timeQueue.poll());
            if(this.timeQueue.size() == 0)
                break;
            else
                queueHeadTime = this.timeQueue.peek();
        }

        return this.timeQueue.size();
    }

    public static boolean within3Seconds(long queueHeadTime, long currentTime){
        if(currentTime - queueHeadTime >= 3000)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Bloomberg_FunctionClicks t = new Bloomberg_FunctionClicks();

        try {
            System.out.println(t.click());    // expect 1
            TimeUnit.SECONDS.sleep(1);
            System.out.println(t.click());    // expect 2
            TimeUnit.SECONDS.sleep(1);
            System.out.println(t.click());    // expect 3
            TimeUnit.SECONDS.sleep(4);
            System.out.println(t.click());    // expect 1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

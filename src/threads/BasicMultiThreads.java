package threads;

/**
 * Created by lizichen1 on 9/26/16.
 */
public class BasicMultiThreads {
    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo( "Thread_1 ");
        ThreadDemo T2 = new ThreadDemo( "Thread_2 ");
        ThreadDemo T3 = new ThreadDemo( "Thread_3 ");
        T1.start();
        T2.start();
        T3.start();
        // wait for threads to end
        try {
            T1.join();
            T2.join();
        } catch( Exception e) {
            System.out.println("Interrupted");
        }
    }
}

class ThreadDemo extends Thread{
    private Thread currentThread;
    private String threadName;
    private SimpleIntObj simpleIntObj;

    ThreadDemo( String name){
        threadName = name;
        simpleIntObj = new SimpleIntObj(0);
    }
    public void run() {
        for (int i = 50; i > 0; i--) {
            System.out.println(this.threadName+ " "+ simpleIntObj.addAndGet());
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start ()
    {
        System.out.println("Starting " +  threadName );
        if (currentThread == null) {
            currentThread = new Thread (this, threadName);
            currentThread.start ();
        }
    }
}

class SimpleIntObj{
    private int count;
    SimpleIntObj(int count){
        this.count = count;
    }
    public synchronized int addAndGet(){
        return count++;
    }
}
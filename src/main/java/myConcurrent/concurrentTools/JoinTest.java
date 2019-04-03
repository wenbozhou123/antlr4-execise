package myConcurrent.concurrentTools;


/**
 * join() 方法 实现主线程等待所有线程操作*/
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->
            System.out.println("thread1 finished")
        );
        Thread t2 = new Thread(() ->
            System.out.println("thread2 finished")
        );
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("all thread finished");

    }
}

package myConcurrent.concurrentTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadpool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadpool.execute(()->{
                try {
                    s.acquire();
                    System.out.println("save data, wait num:" + s.getQueueLength());
                    TimeUnit.SECONDS.sleep(1);
                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadpool.shutdown();
    }
}

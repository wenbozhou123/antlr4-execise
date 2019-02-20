package myConcurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestVolatile {
    public static volatile int race = 0;
    public static void increase(){
        race++;
    }

    public static final int THREADS_COUNT = 20;

    public static void main(String[] args){
        //final CountDownLatch latch = new CountDownLatch(THREADS_COUNT);
        final CyclicBarrier barrier = new CyclicBarrier(THREADS_COUNT);

        Thread[] threads = new Thread[THREADS_COUNT];

        for(int i = 0; i < THREADS_COUNT; i++){
            threads[i] = new Thread(() -> {
                    for(int j = 0; j < 10000; j++){
                        increase();
                    }
                //latch.countDown();
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        //等待所有累加线程都结束
        /*while (Thread.activeCount() > THREADS_COUNT){
            System.out.println("其他活跃的线程数" + Thread.activeCount());
            Thread.yield();
        }*/


        //thread.join() 方式
        /*for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        //等待多线程完成的CountDownLatch
        /*try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //同步屏障CyclicBarrier
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(race);
    }
}

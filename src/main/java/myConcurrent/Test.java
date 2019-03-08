package myConcurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    private static List<String> kk = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (kk){
                    while(true){

                    }
                }

            }
        },"thread1");

        Thread thread2 =new Thread(new Runnable(){

            @Override
            public void run() {
                kk.add("kkkkkkk");
            }
        }, "thread2");

        thread1.start();
        TimeUnit.SECONDS.sleep(3);
        thread2.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(kk.size());
    }

}

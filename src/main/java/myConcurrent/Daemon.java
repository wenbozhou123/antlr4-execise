package myConcurrent;


import java.util.concurrent.TimeUnit;

public class Daemon {
    public static void main(String[] args){
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();

    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("DaemonRunner is running111111.");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("DaemonRunner is running222222.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonRunner finally run.");
            }
        }
    }
}

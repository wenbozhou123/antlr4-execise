package myConcurrent.threadPool;


import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大限制数
    private static final int MAX_WOORKER_NUBMER = 10;
    //线程池的默认数量
    private static final int DEFAULT_WORKER_NUMBER = 5;
    //线程池最小数量
    private static final int MIN_WORKER_NUMBER = 1;
    //这是一个工作列表，将会在里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<>();
    //工作者列表
    private List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    //工作者线程数量
    private int workerNum = DEFAULT_WORKER_NUMBER;
    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();


    public DefaultThreadPool(int num) {
        initializeWorkers(num);
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers){
            worker.shutdown();
        }

    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            //限制新增的Worker数量不超过最大值
            if(num + this.workerNum > MAX_WOORKER_NUBMER){
                num = MAX_WOORKER_NUBMER - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }


    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if (num >= this.workerNum){
                throw new IllegalArgumentException("beyond workerNum");
            }
            //按照给定数量停止Worker
            int count = 0 ;
            while (count < num){
                Worker worker = workers.get(count);
                if (workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
        }

    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable {
        //是否工作
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    //如果工作者列表为空，就wait
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //感知外部对WorkerThread的中断操作，返回
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        //忽略Job执行中的Exception
                        //e.printStackTrace();
                    }

                }
            }
        }

        public void shutdown() {
            this.running = false;
        }
    }

}

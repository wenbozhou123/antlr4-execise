package myConcurrent.concurrentTools;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {

    /**
     * 创建4个内存屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    /**
     * 假设只有4个sheet，所以只启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(()->{
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    @Override
    public void run() {
        int result = 0;
        /**汇总每个sheet计算出的结果*/
        for(Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        /**将结果输出*/
        sheetBankWaterCount.put("result", result);
        System.out.println("result:" +result);
    }

    public static void main(String[] args){
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}

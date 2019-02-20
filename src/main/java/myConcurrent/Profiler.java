package myConcurrent;

import java.util.concurrent.TimeUnit;

public class Profiler {

    /*private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };*/

    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(() -> System.currentTimeMillis());
    //private static final ThreadLocal<Long> TIME_THREADLOCAL_test2 = ThreadLocal.withInitial();



    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final Long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");

    }





}

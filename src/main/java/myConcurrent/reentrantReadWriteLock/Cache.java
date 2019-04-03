package myConcurrent.reentrantReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存示例说明读写锁的使用方式
 * */
public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static Lock r = reentrantReadWriteLock.readLock();
    static Lock w = reentrantReadWriteLock.writeLock();

    //获取一个key对应的Object
    public static final Object get(String key){
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    //设置key对应的value,并返回旧的value
    public static final Object put(String key, Object value){
        w.lock();
        try {
            return map.put(key,value);
        }finally {
            w.unlock();
        }
    }

    //清空所有的内容
    public static final void clear(){
        w.lock();
        try {
            map.clear();
        }finally {
            w.unlock();
        }
    }
}

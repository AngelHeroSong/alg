package Threads;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SafeCache {
    private static HashMap<String, String> cache = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public String get(String key) {
        readLock.lock();
        try {
            String s = cache.get(key);
            return s;
        } finally {
            readLock.unlock();
        }
    }

    public void set(String key, String value) {
        writeLock.lock();
        try {
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SafeCache safeCache = new SafeCache();
        Thread thread1 = new Thread(new Runnable() {
            final String i = "6";

            @Override
            public void run() {
                safeCache.set("" + i, "" + i);
            }
        });
        Thread thread = new Thread(new Runnable() {
            final String i = "7";

            @Override
            public void run() {
                safeCache.set(i, i);
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(safeCache.get("6"));
        System.out.println(safeCache.get("7"));

    }

}

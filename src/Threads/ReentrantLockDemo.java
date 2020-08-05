package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable{

    ReentrantLock lock = new ReentrantLock();

    private static int i;

    @Override
    public void run() {
        for (int j = 0;j<10;j++){
            try {
                lock.lock();
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        Thread thread = new Thread(reentrantLockDemo);
        thread.start();
        thread.join();
        System.out.println(i);
    }


}

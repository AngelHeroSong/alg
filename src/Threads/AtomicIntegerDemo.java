package Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo implements Runnable{
    private static AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo();
        Thread thread = new Thread(atomicIntegerDemo);
        Thread thread1 = new Thread(atomicIntegerDemo);
        thread.start();
        thread1.start();
        thread.join();
        thread.join();
        System.out.println(atomicInteger);
    }
}

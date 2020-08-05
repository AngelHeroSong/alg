package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptiblyLock {
    public ReentrantLock lock = new ReentrantLock();
    public ReentrantLock lock2 = new ReentrantLock();

    public Thread lock1(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                    Thread.sleep(500);
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (lock.isHeldByCurrentThread()) {
                        lock.unlock();
                    }
                    if (lock2.isHeldByCurrentThread()) {
                        lock2.unlock();
                    }
                    System.out.println(Thread.currentThread().getName() + "退出");
                }
            }
        });
        thread.start();
        return thread;

    }

    public Thread lock2(){
        {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock2.lockInterruptibly();
                        Thread.sleep(500);
                        lock.lockInterruptibly();
                        System.out.println(Thread.currentThread().getName() + "执行完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (lock2.isHeldByCurrentThread()) {
                            lock2.unlock();
                        }
                        if (lock.isHeldByCurrentThread()) {
                            lock.unlock();
                        }
                        System.out.println(Thread.currentThread().getName() + "退出");
                    }
                }
            });
            thread.start();
            return thread;

        }
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        InterruptiblyLock interruptiblyLock = new InterruptiblyLock();
        Thread thread = interruptiblyLock.lock1();
        Thread thread1 = interruptiblyLock.lock2();

        while (true) {
            if (System.currentTimeMillis()-l>6000){
                thread1.interrupt();
                 break;
            }
        }

    }

}

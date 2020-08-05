package Threads;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();

                        try {
                            System.out.println(Thread.currentThread() + "获取到semaphore");
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {

                            semaphore.release();

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

package Threads;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 1;i<=5;i++){
            new Worker(i,semaphore).start();
        }
    }
    static class Worker extends Thread{

        private int num;
        private Semaphore semaphore;

        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("员工"+num+"开始使用打印机");
                Thread.sleep(5000);
                System.out.println("员工"+num+"使用完打印机");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

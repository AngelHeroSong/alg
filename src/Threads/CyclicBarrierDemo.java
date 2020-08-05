package Threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有线程准备工作已完成，执行下一项任务");
            }
        });
        for (int i=0;i<10;i++){
            new BussinessThread(cyclicBarrier).start();
        }


    }

    static  class BussinessThread extends Thread{

        private CyclicBarrier cyclicBarrier;

        public BussinessThread(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println("该线程准备工作已经完成，等待其他完成准备工作");
                cyclicBarrier.await();
                System.out.println("其他线程已完成，进入第二阶段工作");
                cyclicBarrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}

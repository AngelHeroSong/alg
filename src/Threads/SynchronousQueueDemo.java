package Threads;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Producer(queue).start();
        new Consumer(queue).start();

    }

    static class Producer extends Thread{
        private SynchronousQueue<Integer> queue;

        public Producer(SynchronousQueue<Integer> queue){
            this.queue = queue;
        }
        @Override
        public void run() {

            while(true){
                int product = new Random().nextInt(1000);
                try {
                    queue.put(product);
                    System.out.println("product a data "+product);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(queue.isEmpty());
            }
        }
    }

    static class Consumer extends Thread{

        private SynchronousQueue<Integer> queue;

        private Consumer(SynchronousQueue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Integer take = queue.take();

                    System.out.println("comsumer data "+take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

package Threads;

public class ThreadLocalTest1 {

    public static void main(String[] args) {
        Runnable task = new Task();
        new Thread(task, "t1").start();
        new Thread(task, "t2").start();
    }

    static class Task implements Runnable {
        private ThreadLocal<Integer> threadLocal1 = ThreadLocal.withInitial(()->0);
        private ThreadLocal<String> threadLocal2 = ThreadLocal.withInitial(()->"a");

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " -> " + threadLocal1.get());
                System.out.println(Thread.currentThread().getName() + " -> " +threadLocal2.get());
                Integer i = threadLocal1.get();
                String s = threadLocal2.get();
                threadLocal1.set(i+1);
                threadLocal2.set(s+"a");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

}
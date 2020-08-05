package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class NewThread extends Thread {

    @Override
    public void run() {
        System.out.println("new thread");
    }
}
class NewRunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(" new Runnable");
    }
}

class MyCallable implements Callable<String>{
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return name;
    }
}
class TestThread{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.继承Thread类
        NewThread newThread = new NewThread();
        newThread.start();
        //2.实现Runnable接口
        NewRunnableImpl newRunnable = new NewRunnableImpl();
        Thread thread = new Thread(newRunnable);
        thread.start();

        //3.实现Callable接口
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future> futures = new ArrayList<>();
        for (int i = 1;i<=5;i++){
            Future<String> future = executorService.submit(new MyCallable(i + ""));
            System.out.println("submit callable thread:"+i);
            futures.add(future);
        }

        executorService.shutdown();
        for (Future future:futures){
            System.out.println("get result from callable thread:"+future.get().toString());
        }

        //4.基于线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i =0;i<10;i++){
            threadPool.submit(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"is Running");
                }
            });
        }
        threadPool.shutdown();


        boolean interrupted = Thread.interrupted();
        boolean interrupted1 = Thread.interrupted();
        System.out.println(interrupted+"  "+interrupted1);


    }
}

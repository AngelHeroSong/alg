package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService fixedthreadPool = Executors.newCachedThreadPool();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        ExecutorService executorService1 = Executors.newWorkStealingPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 second excu");
            }
        },3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1s,且每 3s 执行一次的");
            }
        },1,3,TimeUnit.SECONDS);
    }
}

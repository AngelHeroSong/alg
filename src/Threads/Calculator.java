package Threads;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public interface Calculator {

    /**
     * 把传进来的所有numbers 做求和处理
     *
     * @param numbers
     * @return 总和
     */
    long sumUp(long[] numbers) throws ExecutionException, InterruptedException;
}

/**
 * for循环的方式
 */
class ForLoopCalculator implements Calculator {

    @Override
    public long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ForLoopCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result);
    }
}

/**
 * 线程池的方式
 */
class ExecutorServiceCalculator implements Calculator{

    private int parallism;
    private ExecutorService pool;

    public ExecutorServiceCalculator() {
        parallism = Runtime.getRuntime().availableProcessors();
        pool = Executors.newFixedThreadPool(parallism);
    }

    public static class SumTask implements Callable<Long>{
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long total = 0;
            for (int i = from;i<=to;i++){
                total+=numbers[i];
            }
            return total;
        }
    }

    @Override
    public long sumUp(long[] numbers) throws ExecutionException, InterruptedException {

        int part = numbers.length/parallism;

        List<Future> futureList = new ArrayList<>();
        for (int i =0;i<parallism;i++){
            int start = i*part;
            int end = (i==parallism-1)?numbers.length-1:(i+1)*part-1;
            SumTask sumTask = new SumTask(numbers, start, end);
            Future<Long> future = pool.submit(sumTask);
            futureList.add(future);
        }
        long sum = 0;
        for (Future future:futureList){
              sum+=(long)future.get();
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ExecutorServiceCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result); // 打印结果500500
    }
}

class ForkJoinCalculator implements Calculator{

    private ForkJoinPool pool;

    public ForkJoinCalculator() {
        this.pool = new ForkJoinPool();
    }

    private static class SumTask extends RecursiveTask<Long>{

        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {

            // 当需要计算的数字个数小于6时，直接采用for loop方式计算结果
            if (to - from < 6) {
                long total = 0;
                for (int i = from; i <= to; i++) {
                    total += numbers[i];
                }
                return total;
            } else{
                int middle = from+(to-from)/2;
                SumTask taskLeft = new SumTask(numbers, from, middle);
                SumTask taskRight = new SumTask(numbers, middle + 1, to);
                taskLeft.fork();
                taskRight.fork();
                return taskLeft.join()+taskRight.join();
            }
        }
    }
    @Override
    public long sumUp(long[] numbers) throws ExecutionException, InterruptedException {
        Long invoke = pool.invoke(new SumTask(numbers, 0, numbers.length - 1));
        pool.shutdown();
        return invoke;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();

        Instant start = Instant.now();
        Calculator calculator = new ForkJoinCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result); // 打印结果500500


        //方案四；采用并行流
        Instant start2 = Instant.now();
        long result2 = LongStream.rangeClosed(0, 10000000L).parallel().reduce(0, Long::sum);
        Instant end2 = Instant.now();
        System.out.println("耗时：" + Duration.between(start2, end2).toMillis() + "ms");

        System.out.println("结果为：" + result2); // 打印结果500500
    }


}
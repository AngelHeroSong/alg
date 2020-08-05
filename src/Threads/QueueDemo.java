package Threads;

import java.util.Date;
import java.util.concurrent.*;

public class QueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //公平队列
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1000, true);
        //非公平队列
        ArrayBlockingQueue arrayBlockingQueue2 = new ArrayBlockingQueue(1000, false);

        LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>(100);

        //优先级队列
        Data data = new Data(11);
        Data data2 = new Data(8);

        PriorityBlockingQueue<Data> queue = new PriorityBlockingQueue<>();
        queue.offer(data);
        queue.offer(data2);

        System.out.println(queue.poll());
        System.out.println(queue.poll());




    }

    private static class Data implements Comparable<Data> {
        int id;
        Integer val;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Data(Integer val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Data o) {
            return this.val.compareTo(o.getVal());
        }
    }

    private static class DelayData implements Delayed {


        private Integer value;
        private long delayTime;

        public DelayData(Integer value,long delayTime) {
            this.value = value;
            this.delayTime = delayTime;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }


        public long getDelayTime() {
            return delayTime;
        }

        public void setDelayTime(long delayTime) {
            this.delayTime = delayTime;
        }

        @Override
        public String toString() {
            return "DelayData{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime, TimeUnit.NANOSECONDS) - unit.convert(System.currentTimeMillis(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            DelayData delayData = (DelayData) o;
            return this.value.compareTo(delayData.getValue());
        }

        public static void main(String[] args) throws InterruptedException {
            //延迟队列
            DelayQueue<DelayData> delayQueue = new DelayQueue<>();

            delayQueue.add(new DelayData(1,new Date().getTime()+3000));
            delayQueue.add(new DelayData(9,new Date().getTime()+6000));
            delayQueue.add(new DelayData(18,new Date().getTime()+9000));

           // new
            while (true) {
                System.out.println(delayQueue.take());
            }
        }
    }


}

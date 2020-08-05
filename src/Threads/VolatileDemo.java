package Threads;

public class VolatileDemo {

    static class MyData {
        private int i = 0;

        public int getData() {
            return i;

        }

        public synchronized void add() {
            i++;
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

        public synchronized void desc() {
            i--;
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

        public static void main(String[] args) {
            MyData myData = new MyData();

            for (int i = 0; i < 2; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        myData.add();
                    }
                }).start();
            }
            for (int i = 0; i < 2; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        myData.desc();
                    }
                }).start();
            }

        }


    }
}

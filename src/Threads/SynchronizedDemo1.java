package Threads;

/**
 * 作用于成员方法
 */
public class SynchronizedDemo1 {
    public static void main(String[] args) {
        final SynchronizedDemo1 synchronizedDemo1 = new SynchronizedDemo1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedDemo1.generalMethod1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedDemo1.generalMethod2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public synchronized void generalMethod1() throws InterruptedException {
        for (int i = 1; i < 3; i++) {
            System.out.println("method1 excuete" + i + " time");
            Thread.sleep(3000);
        }
    }

    public synchronized void generalMethod2() throws InterruptedException {
        for (int i = 1; i < 3; i++) {
            System.out.println("method2 excuete" + i + " time");
            Thread.sleep(3000);
        }
    }

}

/**
 * 作用于静态方法
 */

class SynchronizedDemo2 {
    public static void main(String[] args) {
        final SynchronizedDemo2 synchronizedDemo2 = new SynchronizedDemo2();
        final SynchronizedDemo2 synchronizedDemo1 = new SynchronizedDemo2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedDemo1.generalMethod1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedDemo2.generalMethod2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static synchronized void generalMethod1() throws InterruptedException {
        for (int i = 1; i < 3; i++) {
            System.out.println("method1 excuete" + i + " time");
            Thread.sleep(3000);
        }
    }

    public static synchronized void generalMethod2() throws InterruptedException {
        for (int i = 1; i < 3; i++) {
            System.out.println("method2 excuete" + i + " time");
            Thread.sleep(3000);
        }
    }

}

/**
 * 死锁
 */

class SynchronizedDemo3 {
    String lockOb = "aaa";
    String lockOb2 = "addaa";


    public static void main(String[] args) {
        final SynchronizedDemo3 synchronizedDemo1 = new SynchronizedDemo3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedDemo1.generalMethod1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedDemo1.generalMethod2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void generalMethod1() throws InterruptedException {
        synchronized (lockOb) {
            for (int i = 1; i < 3; i++) {
                System.out.println("method1 excuete" + i + " time");
                Thread.sleep(3000);
                synchronized (lockOb2){}
            }
        }


    }

    public void generalMethod2() throws InterruptedException {
        synchronized (lockOb2) {
            for (int i = 1; i < 3; i++) {
                System.out.println("method2 excuete" + i + " time");
                Thread.sleep(3000);
                synchronized (lockOb){}
            }
        }

    }

}

/**
 * 作用于代码块
 */
class SynchronizedDemo4 {
    String lockOb = "aaa";


    public static void main(String[] args) {
        final SynchronizedDemo4 synchronizedDemo1 = new SynchronizedDemo4();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedDemo1.generalMethod1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedDemo1.generalMethod2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void generalMethod1() throws InterruptedException {
        synchronized (lockOb) {
            for (int i = 1; i < 3; i++) {
                System.out.println("method1 excuete" + i + " time");
                Thread.sleep(3000);
            }
        }


    }

    public void generalMethod2() throws InterruptedException {
        synchronized (lockOb) {
            for (int i = 1; i < 3; i++) {
                System.out.println("method2 excuete" + i + " time");
                Thread.sleep(3000);
            }
        }

    }

}
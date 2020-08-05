package Threads;

public class Demo {
    
    private  MyLock myLock = new MyLock();
    private void a(){
        myLock.lock();
        System.out.println("a");
        b();
        myLock.unlock();
    }
    private void b(){
        myLock.lock();
        System.out.println("b");
        myLock.unlock();
    }

    public static void main(String[] args) {

        final Demo demo = new Demo();

        new Thread(new Runnable() {
            public void run() {
                demo.a();

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                demo.a();
            }
        }).start();
    }
}

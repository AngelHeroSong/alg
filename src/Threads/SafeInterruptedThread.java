package Threads;

public class SafeInterruptedThread extends Thread {

    public void run(){
        while (!currentThread().isInterrupted()){
                System.out.println("线程活着");

        }
        if (currentThread().isInterrupted()){
            //处理线程结束前必要的一些资源释放和清理工作，比如释放锁。
            //存储数据到持久化层，发出异常通知，用于实现线程的安全退出。
            try {
                System.out.println("线程中断");
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println(currentThread().isInterrupted());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SafeInterruptedThread thread = new SafeInterruptedThread();
        thread.start();
        Thread.sleep(6000);
        thread.interrupt();

    }

}

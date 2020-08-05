package Threads;

/**
 * 自定义实现可重入锁
 */
public class MyLock {
    /**
     * 判断是否被锁
     */
    private boolean isLocked = false;
    /**
     * 谁拿了锁
     */
    private Thread lockBy = null;

    /**
     * 锁的数量
     */
    private int lockCount = 0;


    public synchronized void lock() {
        Thread thread = Thread.currentThread();
        while (isLocked && lockBy != thread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockBy = thread;
        lockCount++;
    }

    public synchronized void unlock() {
        Thread thread = Thread.currentThread();

        if (isLocked && lockBy == thread){
            lockCount--;
            if (lockCount==0){
                notify();
                isLocked = false;
                lockBy = null;
            }
        }

    }
}

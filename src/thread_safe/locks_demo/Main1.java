package thread_safe.locks_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main1 {
    private static final Lock lock = new ReentrantLock();

    static class MyThread extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println("子线程进入临界区");     // 理论上，这句代码永远到达不了
        }
    }

    public static void main(String[] args) throws InterruptedException {
        lock.lock();

        MyThread t = new MyThread();
        t.start();
        t.join();
    }
}

package thread_safe.locks_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main3 {
    private static final Lock lock = new ReentrantLock();

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                lock.lockInterruptibly();
                System.out.println("子线程进入临界区");     // 理论上，这句代码永远到达不了
            } catch (InterruptedException e) {
                System.out.println("收到停止信号，停止运行");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        lock.lock();

        MyThread t = new MyThread();
        t.start();

        TimeUnit.SECONDS.sleep(2);

        t.interrupt();      // 让t 停下

        t.join();
    }
}

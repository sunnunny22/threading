package thread_safe.locks_demo;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main5 {
    private static final Lock lock = new ReentrantLock();

    static class MyThread extends Thread {
        @Override
        public void run() {
            boolean b = false;
            try {
                b = lock.tryLock(5, TimeUnit.SECONDS);
                if (b == true) {
                    // 加锁成功了
                    System.out.println("加锁成功");
                    System.out.println("子线程进入临界区");     // 理论上，这句代码永远到达不了
                } else {
                    System.out.println("5s 之后加锁失败");
                }
            } catch (InterruptedException e) {
                System.out.println("被人打断了");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        lock.lock();

        MyThread t = new MyThread();
        t.start();

        TimeUnit.SECONDS.sleep(10);

//        t.interrupt();      // 尝试让子线程停下来，但实际会徒劳无功
//        lock.unlock();

        t.join();
    }
}

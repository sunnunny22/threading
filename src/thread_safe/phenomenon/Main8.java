package thread_safe.phenomenon;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 演示线程不安全的现象
public class Main8 {
    // 定义一个共享的数据 —— 静态属性的方式来体现
    static int r = 0;
    // 定义加减的次数
    // COUNT 越大，出错的概率越大；COUNT 越小，出错的概率越小
    static final int COUNT = 1_0000_0000;

    // 定义两个线程，分别对 r 进行 加法 + 减法操作
    // r++ 和 r-- 互斥
    static class Add extends Thread {
        private Lock o;
        Add(Lock o) {
            this.o = o;
        }

        @Override
        public void run() {
            o.lock();
            try {
                for (int i = 0; i < COUNT; i++) {
                    r++;    // r++ 是原子的
                }
            } finally {
                o.unlock();
            }
        }
    }

    static class Sub extends Thread {
        private Lock o;

        Sub(Lock o) {
            this.o = o;
        }

        @Override
        public void run() {
            o.lock();
            try {
                for (int i = 0; i < COUNT; i++) {
                    r--;    // r-- 是原子的
                }
            } finally {
                o.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        Add add = new Add(lock);
        add.start();

        Sub sub = new Sub(lock);
        sub.start();

        add.join();
        sub.join();

        // 理论上，r 被加了 COUNT 次，也被减了 COUNT 次
        // 所以，结果应该是 0
        System.out.println(r);
    }
}

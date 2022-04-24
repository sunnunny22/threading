package thread_safe.phenomenon;

// 演示线程不安全的现象
public class Main2 {
    // 定义一个共享的数据 —— 静态属性的方式来体现
    static int r = 0;

    // 定义加减的次数
    // COUNT 越大，出错的概率越大；COUNT 越小，出错的概率越小
    static final int COUNT = 1_0000_0000;

    // 定义两个线程，分别对 r 进行 加法 + 减法操作
    // r++ 和 r-- 互斥
    static class Add extends Thread {
        @Override
        public void run() {
            synchronized (Main2.class) {
                for (int i = 0; i < COUNT; i++) {
                    r++;    // r++ 是原子的
                }
            }
        }
    }

    static class Sub extends Thread {
        @Override
        public void run() {
            synchronized (Main2.class) {
                for (int i = 0; i < COUNT; i++) {
                    r--;    // r-- 是原子的
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Add add = new Add();
        add.start();

        Sub sub = new Sub();
        sub.start();

        add.join();
        sub.join();

        // 理论上，r 被加了 COUNT 次，也被减了 COUNT 次
        // 所以，结果应该是 0
        System.out.println(r);
    }
}

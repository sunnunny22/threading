package about_data_share;

public class demo2 {

    static class MyThread extends Thread {
        private final int total;

        public MyThread(int total) {
            this.total = total;
        }

        @Override
        public void run() {
            int r = 0;
            for (int i = 0; i < total; i++) {
                r++;
            }

            System.out.println(Thread.currentThread().getName() + ":" + r);     // 1000
        }
    }

    // 一共在内存中开辟几个名叫 r 的内存块？
    // 一共 4 个
    // t1.run.r
    // t2.run.r
    // t3.run.r
    // 主线程.main.r
    public static void main(String[] args) throws InterruptedException {
        int r = 0;
        MyThread t1 = new MyThread(1000);
        t1.start();

        MyThread t2 = new MyThread(200);
        t2.start();

        MyThread t3 = new MyThread(30000);
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println(r);      // 这里的打印是多少？ —— 0
    }
}

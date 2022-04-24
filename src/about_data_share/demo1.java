package about_data_share;

public class demo1 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            int r = 0;
            for (int i = 0; i < 1000; i++) {
                r++;
            }

            System.out.println(Thread.currentThread().getName() + ":" + r);     // 1000
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int r = 0;
        MyThread t = new MyThread();
        t.start();

        t.join();
        System.out.println(r);      // 这里的打印是多少？ —— 0
    }
}

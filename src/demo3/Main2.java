package demo3;

public class Main2 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getName());
        }
    }

    public static void main(String[] args) {
//        Thread thread = Thread.currentThread(); // 当前线程
//        System.out.println(thread.getId());
//
        MyThread t1 = new MyThread();
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        MyThread t3 = new MyThread();
        t3.start();
    }
}

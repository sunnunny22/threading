package demo3;

public class Main3 {
    static class MyThread extends Thread {
//        public MyThread() {
//            setName("我是陈沛鑫");
//        }
        public MyThread() {
            super("我是老陈");  // 调用父类（Thread）的构造方法
        }

        @Override
        public void run() {
            System.out.println(this.getName());
        }
    }

    public static void main(String[] args) {
        Thread thread = Thread.currentThread(); // 当前线程
        System.out.println(thread.getName());

        MyThread t1 = new MyThread();
        t1.start();


        MyThread t2 = new MyThread();
        t2.start();

        MyThread t3 = new MyThread();
        t3.start();
    }
}

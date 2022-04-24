package current_Theard;

public class Main {
    static class MyThread extends Thread {
        @Override
        public void run() {
            printCurrentThreadAttributes();
        }
    }

    private static void printCurrentThreadAttributes() {
        // 返回当前（这个方法是在哪个线程中被调用的）线程的引用
        Thread t = Thread.currentThread();
        System.out.println(t.getId());
        System.out.println(t.getName());
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("t1");
        t1.start();

        MyThread t2 = new MyThread();
        t2.setName("t2");
        t2.start();

        MyThread t3 = new MyThread();
        t3.setName("t3");
        t3.start();

        printCurrentThreadAttributes();
    }
}

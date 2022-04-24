package demo4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    private static class B extends Thread {
        @Override
        public void run() {
            // 模拟 B 要做很久的工作
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            println("B 说：我的任务已经完成");
        }
    }

    private static void println(String msg) {
        Date date = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date) + ": " + msg);
    }

    public static void main(String[] args) throws InterruptedException {
        B b = new B();
        b.start();
        println("A 自己先去吃饭");
        // 有 join 和没有 join 的区别
        b.join();
        println("A 说：B 给我把钱送来了，结账走人");
    }
}

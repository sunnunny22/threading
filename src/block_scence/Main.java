package block_scence;

import java.util.Scanner;

public class Main {
    static long fib(int n) {   // Main类下的一个函数
        if (n == 0 || n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // 没有引入线程时
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入一个数字: ");
            int n = scanner.nextInt();

            long r = fib(n);
            System.out.printf("fib(%d) = %d\n", n, r);
        }
    }

    // 引入一个线程来进行计算，主线程只负责读取用户输入
    static class CalcFib extends Thread {
        private final int n;

        public CalcFib(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long r = fib(n);
            System.out.printf("fib(%d) = %d\n", n, r);
        }
    }


    // 开个饭店，如果只有一个人：既当前台 + 也当厨师。如果用户点了耗时比较久的菜（把我占用了），导致没法接待新顾客
    // 有了线程之后，“我”只负责前台工作，做菜交给另一个人，即使做菜比较慢，也不影响其他用户的体验
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入一个数字: ");
            int n = scanner.nextInt();
            // 读取输入后，创建一个线程去计算
            Thread t = new CalcFib(n);
            t.start();
            // 主线程直接读取下一个输入
        }
    }
}

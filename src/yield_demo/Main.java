package yield_demo;


public class Main {
    static class PrintWhoAmI extends Thread {
        private final String who;

        public PrintWhoAmI(String who) {
            this.who = who;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("我是 " + who);
                if (who.equals("张三")) {
                    Thread.yield();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintWhoAmI 张三 = new PrintWhoAmI("张三");
        PrintWhoAmI 李四 = new PrintWhoAmI("李四");
        张三.start();
        李四.start();
    }
}

package demo2;

/*
1. 继承 java.lang.Thread 类
2. 光继承的情况，这个线程中一条指令都没有
   所以我们需要给线程书写让它执行的指令（以语句的形式）
   通过重写 run 方法
 */
public class MyFirstThreadClass extends Thread {
    public MyFirstThreadClass() {
        System.out.println("可以正常的使用构造方法之类的");
    }

    @Override
    public void run() {
        // 这个方法下写的所有代码，如果正确创建线程的话，都会运行在新的线程执行流中
        System.out.println("这是我的第一个线程");
    }
}

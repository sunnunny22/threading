package demo1;

/*
1. 实现 java.lang.Runnable 接口
2. 通过重写 run 方法，来指定任务要做的工作
   至于这个线程要不要交给一个新的线程去执行，我们这里是不知道的
 */
public class MyFirstTask implements Runnable {
    @Override
    public void run() {
        System.out.println("这是我的第一个任务的第一句话");
    }
}

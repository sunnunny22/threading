package demo1;

public class Main {
    MyFirstTask Task = new MyFirstTask();
     Thread thread = new Thread(Task);
    // 创建了一个任务对象
            // 把 task 作为 Thread 的构造方法传入
    // 让这个新创建的 Thread 去执行 task 任务
    // 语句就运行在新的线程中
    // 这里只是创建出线程，暂时还没有运行
}

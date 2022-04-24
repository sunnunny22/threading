package thread_safe.exclusive;

/*
SomeClass s1 = new SomeClass();
SomeClass s2 = new SomeClass();
SomeClass s3 = s1;
 */
// SomeClass.class 是一种类对象，类型是 Class 类型
// 每个被加载的类（对于我们代码中，可以认为每个类）都有一个 && 仅有一个 类对象
public class SomeClass {
    synchronized void m1() { }  // 同步方法

    // 同步静态方法 -> 视为对 SomeClass.class 加锁
    synchronized static void m2() { }   // 同步静态方法
    void m3() { }
    void m4() {
        synchronized (this) { }
    }
    void m5() {
        synchronized (SomeClass.class) { }
    }
    Object o1 = new Object();
    void m6() {
        synchronized (o1) { }
    }
    static Object o2 = new Object();
    void m7() {
        synchronized (o2) { }
    }
}

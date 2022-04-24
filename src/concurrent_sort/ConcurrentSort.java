package concurrent_sort;

import java.util.Arrays;

// 众人拾柴火焰高
public class ConcurrentSort {
    // 进行排序的线程
    static class SortWorker extends Thread {
        private final long[] array;
        private final int fromIndex;
        private final int toIndex;
        // 利用构造方法，将待排序的数组区间情况，传入
        // 对 array 的 [fromIndex, toIndex) 进行排序
        SortWorker(long[] array, int fromIndex, int toIndex) {
            this.array = array;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        public void run() {
            // 具体的排序过程，这里使用 Array.sort 做模拟
            Arrays.sort(array, fromIndex, toIndex);
        }
    }

    // 记录排序耗时
    public static void main(String[] args) throws InterruptedException {
        long[] array = ArrayHelper.generateArray(4_000_0000);

        // 分别是
        // [0, 1000_0000)
        // [1000_0001, 2000_0000)
        // [2000_0001, 4000_0000)
        // [3000_0001, 4000_0000)
        long s = System.currentTimeMillis();
        Thread t1 = new SortWorker(array, 0, 1000_0000);
        t1.start();

        Thread t2 = new SortWorker(array, 1000_0001, 2000_0000);
        t2.start();

        Thread t3 = new SortWorker(array, 2000_0001, 3000_0000);
        t3.start();

        Thread t4 = new SortWorker(array, 3000_0001, 4000_0000);
        t4.start();

        // 4 个线程开始分别的进行排序了
        // 等待 4 个线程全部排序完毕
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        // 4 个线程一定全部结束了
        // TODO：进行 4 路归并，将 4 个有序数组，归并成一个有序数组
        long e = System.currentTimeMillis();

        long elapsed = e - s;
        System.out.println(elapsed);
    }
}

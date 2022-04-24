package concurrent_sort;



import java.util.Arrays;

public class SingleSort {
    // 记录排序耗时
    public static void main(String[] args) throws InterruptedException {
        long[] array = ArrayHelper.generateArray(4_000_0000);

        // 分别是
        // [0, 1000_0000)
        // [1000_0001, 2000_0000)
        // [2000_0001, 3000_0000)
        // [3000_0001, 4000_0000)
        long s = System.currentTimeMillis();
        Arrays.sort(array, 0, 1000_0000);
        Arrays.sort(array, 1000_0001, 2000_0000);
        Arrays.sort(array, 2000_0001, 3000_0000);
        Arrays.sort(array, 3000_0001, 4000_0000);
        // TODO：进行 4 路归并，将 4 个有序数组，归并成一个有序数组
        long e = System.currentTimeMillis();

        long elapsed = e - s;
        System.out.println(elapsed);
    }
}

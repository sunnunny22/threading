package concurrent_sort;

import java.util.Random;

class ArrayHelper {
    public static long[] generateArray(int n) {
        Random random = new Random(20220420);
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}

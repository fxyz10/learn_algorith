package class01;

import java.util.Arrays;

public class Code05_nearLeft {
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void charu(int[] a) {
        for (int i = 0; i < a.length; i ++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j --) {
                swap(a, j, j + 1);
            }
        }
    }

    // 在有序arr上，找满足>=value的最左位置
    public static int nearLeft(int[] a, int num) {
        int L = 0;
        int R = a.length - 1;
        int mid;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (a[mid] >= num) {
                R = mid - 1;
                index = mid;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        charu(a);
        System.out.println(Arrays.toString(a));
        int index = nearLeft(a, 3);
        System.out.println(index + ": " + a[index]);
        index = nearLeft(a, 4);
        System.out.println(index + ": " + a[index]);
    }
}

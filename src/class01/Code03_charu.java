package class01;

import java.util.Arrays;

public class Code03_charu {

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

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        System.out.println(Arrays.toString(a));
        charu(a);
        System.out.println(Arrays.toString(a));
    }
}

package class01;

import java.util.Arrays;

public class Code01_xuanze {

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void xuanze(int[] a) {
        for (int i = 0; i < a.length - 1; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j ++) {
                minIndex = a[j] < a[minIndex] ? j : minIndex;
            }
            swap(a, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        System.out.println(Arrays.toString(a));
        xuanze(a);
        System.out.println(Arrays.toString(a));
    }
}



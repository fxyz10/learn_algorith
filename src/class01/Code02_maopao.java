package class01;

import java.util.Arrays;

public class Code02_maopao {

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void maopao(int[] a) {
        for (int i = 0; i < a.length - 1; i ++) {
            for (int j = i + 1; j < a.length; j ++) {
                if (a[j] < a[i])
                    swap(a, i, j);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        System.out.println(Arrays.toString(a));
        maopao(a);
        System.out.println(Arrays.toString(a));
    }
}

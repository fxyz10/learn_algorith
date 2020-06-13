package class03;

import java.util.Arrays;

public class Code01_guibing {

    public static void merge(int[] a, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i ++] = a[p1] <= a[p2] ? a[p1 ++] : a[p2 ++];
        }
        while (p1 <= M) {
            help[i ++] = a[p1 ++];
        }
        while (p2 <= R) {
            help[i ++] = a[p2 ++];
        }
        for (i = 0; i < help.length; i ++) {
            a[L + i] = help[i];
        }
    }

    public static void process(int[] a, int L, int R) {
        if (L == R)
            return;
        int mid = L + ((R - L) >> 1);
        process(a, L, mid - 1);
        process(a, mid + 1, R);
        merge(a, L, mid, R);
    }

    public static void guibing(int[] a) {
        process(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        System.out.println(Arrays.toString(a));
        guibing(a);
        System.out.println(Arrays.toString(a));
    }
}

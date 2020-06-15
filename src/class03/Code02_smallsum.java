package class03;

import java.util.Arrays;

public class Code02_smallsum {

    public static int smallsum(int[] a) {
        if (a == null || a.length < 2)
            return 0;
        return process(a, 0, a.length - 1);
    }

    public static int process(int[] a, int L, int R) {
        if (L == R)
            return 0;
        int mid = L + ((R - L) >> 1);
        return process(a, L, mid) +
                process(a, mid + 1, R) +
                merge(a, L, mid, R);
    }

    public static int merge(int[] a, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int i = 0;
        int sum = 0;
        while (p1 <= M && p2 <= R) {
            sum += a[p1] < a[p2] ? (R - p2 + 1) * a[p1] : 0;
            help[i ++] = a[p1] < a[p2] ? a[p1 ++] : a[p2 ++];
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
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        System.out.println(Arrays.toString(a));
        System.out.println(smallsum(a));
        System.out.println(Arrays.toString(a));
    }
}

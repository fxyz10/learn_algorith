package class02;

public class Code08_getMax {
    public static int getMax(int[] a) {
        return process(a, 0, a.length - 1);
    }

    public static int process(int[] a, int L, int R) {
        if (L == R)
            return a[L];
        int mid = L + ((R - L) >> 1);
        int leftMax = process(a, L, mid);
        int rightMax = process(a, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}

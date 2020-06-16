package class03;

import common.ArrayCommon;

import java.util.Arrays;

public class Code03_kuaipai {

    public static int partition(int[] a, int L, int R) {
        if (L > R)
            return -1;
        if (L == R)
            return L;
        int less = L - 1;
        int index = L;
        while (index < R) {
            if (a[index] <= a[R]) {
                ArrayCommon.swap(a, index, ++ less);
            }
            index ++;
        }
        ArrayCommon.swap(a, R, ++ less);
        return less;
    }

    public static void process1(int[] a, int L, int R) {
        if (L >= R)
            return;
        int M = partition(a, L, R);
        process1(a, L, M - 1);
        process1(a, M + 1, R);
    }

    public static void kuaipai1(int[] a) {
        if (a == null || a.length < 2)
            return;
        process1(a, 0, a.length - 1);
    }

    public static int[] netherlandsFlag(int[] a, int L, int R) {
        if (L > R)
            return new int[] {-1, -1};
        if (L == R)
            return new int[] {L, R};
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (a[index] == a[R]) {
                index ++;
            } else if (a[index] < a[R]) {
                ArrayCommon.swap(a, index ++, ++ less);
            } else {
                ArrayCommon.swap(a, index, -- more);
            }
        }
        ArrayCommon.swap(a, more, R);
        return new int[] {less + 1, more};
    }

    public static void  process2(int[] a, int L, int R) {
        if (L >= R)
            return;
        int[] equalsArea = netherlandsFlag(a, L, R);
        process2(a, L, equalsArea[0] - 1);
        process2(a, equalsArea[1] + 1, R);
    }

    public static void kuaipai2(int[] a) {
        if (a == null || a.length < 2)
            return;
        process2(a, 0, a.length - 1);
    }

    public static void  process3(int[] a, int L, int R) {
        if (L >= R)
            return;
        int random = L + (int)(Math.random() * (R - L + 1));
        ArrayCommon.swap(a, random, R);
        int[] equalsArea = netherlandsFlag(a, L, R);
        process2(a, L, equalsArea[0] - 1);
        process2(a, equalsArea[1] + 1, R);
    }

    public static void kuaipai3(int[] a) {
        if (a == null || a.length < 2)
            return;
        process3(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        int[] b = ArrayCommon.copyArray(a);
        int[] c = ArrayCommon.copyArray(a);
        System.out.println(Arrays.toString(a));
        System.out.println("=================");
        // 普通快排
        kuaipai1(a);
        // 荷兰国旗
        kuaipai2(b);
        // 随机快排
        kuaipai3(c);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}

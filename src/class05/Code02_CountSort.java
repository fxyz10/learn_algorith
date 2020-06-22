package class05;


import java.util.Arrays;

public class Code02_CountSort {

    public static void countSort(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // 长度要比实际大1 0位置无值
        int[] bucket = new int[max - min + 2];
        for (int i : a) {
            bucket[i] ++;
        }
        int i = 0;
        for (int j = 1; j < bucket.length; j ++) {
            while (bucket[j] -- > 0) {
                a[i ++] = j;
            }
        }
    }

    // 有范围的正整数可用
    public static void main(String[] args) {
        int[] a = {5, 3, 1, 3, 8, 9, 2};
        System.out.println(Arrays.toString(a));
        countSort(a);
        System.out.println(Arrays.toString(a));
    }
}

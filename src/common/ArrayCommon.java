package common;

import java.util.Arrays;

public class ArrayCommon {

    /**
     *
     * @param maxSize  数组最大长度
     * @param maxValue 数组最大值
     * @return 随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    /**
     *
     * @param array 数组
     * @return 复制一份相同的数组
     */
    public static int[] copyArray(int[] array) {
        if (array == null)
            return null;
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i ++) {
            res[i] = array[i];
        }
        return res;
    }

    /**
     *
     * @param array 返回排好序的数组
     */
    public static void sortRandomArray(int[] array) {
        Arrays.sort(array);
    }

    /**
     * 交换数组i j两个位置上的元素
     * @param array 数组
     * @param i 第i个
     * @param j 第j个
     */
    public static void swap(int[] array, int i , int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

        // 两值不相等时交换可使用异或 相等会返回0
//        array[i] = array[i] ^ array[j];
//        array[j] = array[i] ^ array[j];
//        array[i] = array[i] ^ array[j];

    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int[] a = generateRandomArray(5, 5);
            int[] copyA = copyArray(a);
            System.out.println(Arrays.toString(a));
            sortRandomArray(a);
            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(copyA));
            System.out.println("------------");
        }
    }

}

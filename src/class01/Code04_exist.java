package class01;

public class Code04_exist {

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

    public static boolean exist(int[] a, int num) {
        int L = 0;
        int R = a.length - 1;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (a[mid] == num) {
                return true;
            } else if (a[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return a[L] == num;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        charu(a);
        System.out.println(exist(a, 7));
    }
}

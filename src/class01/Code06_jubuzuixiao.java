package class01;

public class Code06_jubuzuixiao {

    // 返回局部最小值索引
    public static int getLess(int[] a) {
        if (a == null || a.length == 0)
            return -1;
        if (a.length == 1 || a[0] < a[1])
            return 0;
        if (a[a.length - 1] < a[a.length - 2])
            return a.length - 1;
        int L = 0;
        int R = a.length - 1;
        int mid;
        while (L < R) {
            mid = (L + R) / 2;
            if (a[mid] > a[mid - 1]){
                R = mid - 1;
            } else if (a[mid] > a[mid + 1]) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return L;
    }


    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 2, 9};
        int index = getLess(a);
        System.out.println(index + ": " + a[index]);
    }
}

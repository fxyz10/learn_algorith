package class01;


public class Code07_eor {

    // arr中，只有一种数，出现奇数次
    public static void eor1(int[] a) {
        int eor = 0;
        for (int i : a) {
            eor ^= i;
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void eor2(int[] a) {
        int eor = 0;
        for (int i : a) {
            eor ^= i;
        }
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i : a) {
            if ((i & rightOne) == 0) {
                onlyOne ^= i;
            }
        }
        System.out.println(onlyOne);
        System.out.println(onlyOne ^ eor);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
        System.out.println("===========");

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        eor1(arr1);
        System.out.println("===========");

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        eor2(arr2);

    }
}

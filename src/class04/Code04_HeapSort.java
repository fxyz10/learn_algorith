package class04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_HeapSort {



    public static void main(String[] args) {
        int[] a = {5, 3, 1, 8, 9, 2};
        System.out.println(Arrays.toString(a));
//        heapSort(a);
//        System.out.println(Arrays.toString(a));

        System.out.println("===========");
        System.out.println("===========");
        System.out.println("===========");

        PriorityQueue<Integer> pq = new PriorityQueue<>(new myCom());
        pq.add(4);
        pq.add(3);
        pq.add(5);
        pq.add(2);
        pq.add(1);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static class myCom implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}

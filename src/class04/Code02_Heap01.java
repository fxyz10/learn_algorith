package class04;

public class Code02_Heap01 {

    public static class MyMaxHeap{

        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (heapSize == limit)
                throw new RuntimeException("heap is full");
            heap[heapSize] = value;
            // 调整为堆 heapSize++
            heapInsert(heap, heapSize ++);
        }

        public int pop() {
            int ans = heap[0];
            swap(heap, 0, -- heapSize);
            // 重新调整为堆 heapSize--
            heapify(heap, 0, heapSize);
            return ans;
        }

        private void heapify(int[] a, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && a[left + 1] > a[left] ? left + 1 : left;
                largest = a[largest] > a[index] ? largest : index;
                if (largest == index)
                    break;
                swap(a, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void heapInsert(int[] a, int index) {
            while (a[index] > a[(index - 1) / 2]) {
                swap(a, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        MyMaxHeap heap = new MyMaxHeap(5);
        heap.push(2);
        heap.push(1);
        heap.push(5);
        heap.push(4);
        heap.push(3);
        while (!heap.isEmpty()) {
            System.out.println(heap.pop());
        }
    }
}

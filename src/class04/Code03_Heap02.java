package class04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Code03_Heap02 {

    private static class MyHeap<T>{

        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> comparator) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            this.comparator = comparator;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public int size() {
            return heapSize;
        }

        public boolean contains(T key) {
            return indexMap.containsKey(key);
        }

        public void push(T value) {
            heap.add(value);
            indexMap.put(value, heapSize);
            heapInsert(heapSize ++);
        }

        public T pop() {
            T ans = heap.get(0);
            int end = heapSize - 1;
            swap(0, end);
            heap.remove(end);
            indexMap.remove(ans);
            // 调整为堆
            heapify(0, -- heapSize);
            return ans;
        }

        public void resign(T value) {
            int valueIndex = indexMap.get(value);
            heapInsert(valueIndex);
            heapify(valueIndex, heapSize);
        }

        private void heapify(int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize
                        && comparator.compare(heap.get(left + 1), heap.get(index)) < 0
                        ? left + 1 : left;
                largest = comparator.compare(heap.get(largest), heap.get(index)) < 0
                        ? largest : index;
                if (largest == index)
                    break;
                swap(largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void heapInsert(int index) {
            while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int i, int j) {
            T t1 = heap.get(i);
            T t2 = heap.get(j);
            heap.set(i, t2);
            heap.set(j, t1);
            indexMap.put(t1, j);
            indexMap.put(t2, i);
        }
    }

    public static class Student {
        public int classNo;
        public int age;
        public int id;
        public Student(int c, int a, int i) {
            classNo = c;
            age = a;
            id = i;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "classNo=" + classNo +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
    }

    public static class StudentComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(2, 50, 11111);
        Student s2 = new Student(1, 60, 22222);
        Student s3 = new Student(6, 10, 33333);
        Student s4 = new Student(3, 20, 44444);
        Student s5 = new Student(7, 72, 55555);
        Student s6 = new Student(1, 14, 66666);

        MyHeap<Student> myHeap = new MyHeap<>(new StudentComparator());
        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);
        while (!myHeap.isEmpty()) {
            Student cur = myHeap.pop();
            System.out.println(cur.toString());
        }
    }

}

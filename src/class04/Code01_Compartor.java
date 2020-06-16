package class04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Code01_Compartor {

    public static class descArray implements Comparator<Integer> {
        @Override
        public int compare(Integer a0, Integer a1) {
            return a1 - a0;
        }
    }

    public static class comparStudent implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            //return o1.id - o2.id;
            //return o1.age - o2.age;
            // 按ID升序 ID相同age降序
            return o1.id != o2.id ? o1.id - o2.id : o2.age - o1.age;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5, 3, 1, 8, 9, 2};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new descArray());
        System.out.println(Arrays.toString(a));

        System.out.println("===================");
        System.out.println("===================");

        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 1, 22);
        Student student4 = new Student("D", 2, 22);
        Student[] students = new Student[] { student1, student2, student3, student4};
        Arrays.sort(students, new comparStudent());
        System.out.println(Arrays.toString(students));

        System.out.println("===================");
        System.out.println("===================");

        // 堆：默认小根堆。可通过实现比较器，改为大根堆。
        PriorityQueue<Student> minHeap = new PriorityQueue<>(new comparStudent());
        minHeap.add(student2);
        minHeap.add(student3);
        minHeap.add(student1);
        minHeap.add(student4);
        minHeap.add(student1);
        while (!minHeap.isEmpty()) {
            Student s = minHeap.poll();
            System.out.println(s.toString());
        }

        System.out.println("===================");
        System.out.println("===================");

        // 有序表
        TreeSet<Student> ts = new TreeSet<>(new comparStudent());
        ts.add(student2);
        ts.add(student3);
        ts.add(student1);
        ts.add(student4);
        ts.add(student1);
        System.out.println(ts.first().toString());
        System.out.println(ts.last().toString());
    }

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }
    }
}

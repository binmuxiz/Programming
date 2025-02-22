package _09_Heap;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class HeapMain {
    public static void main(String[] args) {

        Heap<Integer> heap = new Heap<>();

        // add test
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < 7; i++) {
            int j = rand.nextInt(14);
            System.out.print(j + " ");
            heap.add(j);
        }
        System.out.println();

        for (Object val : heap.toArray()) {
            System.out.print(val + " ");
        }
        System.out.println();

        // peek test & remove test
        int size = heap.size();

        for (int i = 1; i <= size; i++) {
            System.out.print(heap.peek() + " ");
            System.out.print(heap.remove());
            System.out.println();
        }
        System.out.println();

        // isEmptyTest
        System.out.println(heap.isEmpty());

        // containsTest
        System.out.println(heap.contains(1));
        heap.add(1);
        System.out.println(heap.contains(1));

        System.out.println("===========================");
        System.out.println("Student 객체 contains test");
        Heap<Student> studentHeap = new Heap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        studentHeap.add(new Student("이은빈"));
        studentHeap.add(new Student("김현민"));
        System.out.println(studentHeap.contains(new Student("이은빈")));
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

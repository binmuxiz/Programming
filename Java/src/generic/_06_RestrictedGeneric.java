package generic;

/**
 * <K super T> // T와 T의 부모(조상) 타입만 가능 (K는 들어오는 타입으로 지정됨)
 * <? super T> // T와 T의 부모(조상) 타입만 가능
 * ? super T : 하한 경계
 */
public class _06_RestrictedGeneric {
    public static void main(String[] args) {
        // Student 클래스는 Comparable을 구현하고 있지 않다. Compile error!
//        SaltClass<Student> saltClass = new SaltClass<Student>();

        // Student2 클래스는 Comparable을 구현하고 있지만, Comparable<Student> 타입을 구현하고 있지 않다.
//        SaltClass<Student2> saltClass = new SaltClass<>();

        SaltClass<Student3> saltClass = new SaltClass<>();
    }
}

class SaltClass<E extends Comparable<E>> {

}

class Student {

}


class Student2 implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Student3 implements Comparable<Student3> {

    String name;

    @Override
    public int compareTo(Student3 o) {
        return 0;
    }
}
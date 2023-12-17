package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 제네릭 타입 특정 범위로 좁혀서 제한하고 싶은 경우
 * <K extends T> // T와 T의 자손 타입만 가능 (K는 들어오는 타입으로 지정됨). 클래스 선언시, 메소드 리턴타입에 사용 가능
 * <? extends T> // T와 T의 자손 타입만 가능. 메소드의 매개변수, 리턴타입에 사용 가능
 * extends T : "상한 경계"라고 부른다
 * '유형 경계를 지정'하는 것은 같으나 경계가 지정되고 K는 특정 타입으로 지정이 되지만, ?는 타입이 지정되지 않는다.
 *
 */
public class _05_RestrictedGeneric {
    public static void main(String[] args) {
        MyList<Double> a = new MyList<>(10);
//        a.add(1);
        a.add(2.1);
//        a.add("str");

//        MyList<String> b = new MyList<String>(10);


    }
}


class MyList<K extends Number> {

    K[] array;
    int size;

    public MyList(int capacity) {
        this.array = (K[]) new Object[capacity];
        this.size = 0;
    }

    void add(K element) {
        this.array[size++] = element;
    }

    void method1(List<? extends Number> list) {

    }


//    <K extends Number> List<K> toList() {
//
//        return null;
//    }
}


class MyList2 {
    public void method1(List<? extends Number> list) {

    }
}

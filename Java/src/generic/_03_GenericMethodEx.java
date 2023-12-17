package generic;

public class _03_GenericMethodEx<E> {

    private E element;

    void set(E element) {
        this.element = element;
    }

    E get() {
        return element;
    }

    // 제네릭 메소드
    <T> T genericMethod(T o) {
        return o;
    }

    // 정적메소드에서 제네릭을 사용하려면 별도의 제네릭 타입을 선언해야 한다.
//    static E genericMethod(E o) {
//        return o;
//    }
    /**
     * static 메소드는 객체를 생성하지 않고 클래스로부터 접근할 수 있는 메소드이다.
     * 하지만 제네릭 클래스는 객체를 생성할 때 generic 타입을 지정해주어야 한다.
     * static 메소드는 객체가 생성되기 전에 이미 메모리에 올라가는데 타입을 얻어올 수가 없다.
     * 따라서 아래의 generic method가 아닌 일반 정적메소드는
     * 매개변수 또는 리턴타입에 제네릭을 사용할 수 없는 것이다.
     *
     * 그래서 제네릭이 사용되는 메소드를 정적 메소드로 두고 싶은 경우 제네릭 클래스와 별도로
     * 독립적인 제네릭이 사용되어야 하는 것이다.
     */


}

class Main3 {
    public static void main(String[] args) {
        _03_GenericMethodEx<String> a = new _03_GenericMethodEx<>();
        _03_GenericMethodEx<Integer> b = new _03_GenericMethodEx<>();

        a.set("10");
        b.set(10);

        System.out.println("a data : " + a.get());
        System.out.println("E type of a : " + a.get().getClass().getName());

        System.out.println("b data : " + b.get());
        System.out.println("E type of b : " + b.get().getClass().getName());

        System.out.println();

        // generic method Integer
        System.out.println("<T> return type  : " + a.genericMethod(3).getClass().getName());

        // generic method string
        System.out.println("<T> return type  : " + b.genericMethod("abcd").getClass().getName());

        // generic method class name b
        System.out.println("<T> return type : " + a.genericMethod(b).getClass().getName());

        //TODO 제네릭 메소드 왜 사용하나??
        /**
         * 클래스에서 지정한 제네릭과 별도로 메소드에서 제네릭 유형을 독립적으로 선언하여 사용할 수 있다.
         * 이런 방식이 필요한 이유는 바로 "정적 메소드로 선언할 때 필요"하기 떄문이다.
         *
         */

    }
}
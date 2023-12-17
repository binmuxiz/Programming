package generic;

public class _01_GenericClassEx<E> {
    private E element;

    void set(E element) {
        this.element = element;
    }

    E get() {
        return element;
    }
}

class Main {
    public static void main(String[] args) {
        _01_GenericClassEx<String> a = new _01_GenericClassEx<>();
        _01_GenericClassEx<Integer> b = new _01_GenericClassEx<>();

        a.set("10");
        b.set(10);

        System.out.println("a data : " + a.get());
        System.out.println("E Type of a :  " + a.get().getClass().getName());

        System.out.println("b data : " + b.get());
        System.out.println("E Type of b :  " + b.get().getClass().getName());



    }
}

package lamda_and_stream;

// 특정 수를 입력받아 해당 수의 제곱과 루트를 구하는 람다 표현식을 작성하세요.
// 조건 : Interface 정의, 하나의 표현식으로 두 가지 기능 구현

public class Practice1 {
    public static void main(String[] args) {
        CalculateClass calculateClass = new CalculateClass();
        calculateClass.defaultMethod();
        CalculateInterface.method1();
        CalculateInterface.method2();

        int n = 4;
        CalculateInterface<Integer> c1 = num -> num * num;

        System.out.println(c1.calculate(n));

        double d = 4.0;
        CalculateInterface<Double> c2 = num -> Math.sqrt(num);
        System.out.println(c2.calculate(d));


    }
}

@FunctionalInterface
interface CalculateInterface<T> {
    T calculate(T t);

    static void method1() {
        System.out.println("CalculateInterface.method1");
    }

    static void method2() {
        System.out.println("CalculateInterface.method2");
    }

    default void defaultMethod() {
        System.out.println("CalculateInterface.CalculateInterface");
    }
}

class CalculateClass<T> implements CalculateInterface<T>{

    @Override
    public T calculate(T t) {
        return t;
    }

    @Override
    public void defaultMethod() {
        CalculateInterface.super.defaultMethod();
    }
}
package lamda_and_stream;

// 특정 수를 입력받아 해당 수의 제곱과 루트를 구하는 람다 표현식을 작성하세요.
// 조건 : Interface 정의, 하나의 표현식으로 두 가지 기능 구현

public class Practice1 {
    public static void main(String[] args) {
        int n = 4;
        CalculateInterface<Integer> c1 = num -> num * num;
        System.out.println(c1.calculate(n));

        // 런타임 시 익명클래스 생성
//        LambdaPractice1 lp = new LambdaPractice1() {
//            @Override
//            public double squareAndRoot(int num) {
//                return num * num;
//            }
//        };

        double d = 4.0;
        CalculateInterface<Double> c2 = num -> Math.sqrt(num);
        System.out.println(c2.calculate(d));


    }
}

interface CalculateInterface<T> {
    T calculate(T t);
}

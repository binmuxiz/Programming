import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // 1. 팩토리얼
        int n = 5;
        int result = 1;
        for (int i = n; i > 1; i--) {
            result *= i;
        }
        System.out.println("== 팩토리얼 ==");
        System.out.println("result : " + result);
        System.out.println(IntStream.range(2,6).reduce(1, (x, y) -> (x * y)));

        // 2. 순열
        n = 5;
        int r = 5;
        result = 1;
        for (int i = n; i > n-r+1; i--) {
            result *= i;
        }
        System.out.println("== 순열 ==");
        System.out.println("result : " + result);

        // 3. 중복 순열
        n = 4;
        r = 2;
        result = 1;

        for (int i = 0; i < r; i++) {
            result *= n;
        }
        System.out.println("== 중복 순열");
        System.out.println("result : " + result);
        System.out.println(Math.pow(n, r));

        // 4. 원순열
        n = 3;
        result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        System.out.println("== 원순열 ==");
        System.out.println("result : " + result);
    }
}

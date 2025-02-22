
// 팩토리얼을 재귀함수로 구현
public class Practice1 {

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
    }

    private static int factorial(int n) {
        if (n <= 1)
            return 1;

        return n * factorial(n - 1);
    }
}

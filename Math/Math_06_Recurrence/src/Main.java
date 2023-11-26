public class Main {

    public static void main(String[] args) {

        // 점화식 -> 반복문, 재귀함수

        System.out.println("== 점화식 / 재귀함수 연습1 == ");
        // 1,3,9,27, ... 의 n번쨰 수
        int n = 4;
        int result = 1;
        for (int i = 1; i < n; i++) {
            result *= 3;
        }
        System.out.println("결과 : " + result);
        System.out.println(recursion1(n));


        System.out.println("== 점화식 / 재귀함수 연습2 == ");
        // 1,2,3,4,5,6,...의 n번째까지의 합
        n = 1;
        result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        System.out.println("결과 : " + result);
        System.out.println(recursion2(n));


        System.out.println("== 점화식 / 재귀함수 연습 3 ==");
        // 1,1,2,3,5,8,13, ...의 n번 째 수
        n = 6;
        int a = 1, b = 1;
        result = 1;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        System.out.println("결과 : " + result);
        System.out.println(recursion3(n));
    }


    static int recursion1(int n) {
        if (n == 1) {
            return 1;
        }
        return 3 * recursion1(n - 1);
    }

    static int recursion2(int n) {
        if (n == 1)
            return 1;

        return n + recursion2(n-1);
    }

    static int recursion3(int n) {
        if (n < 3)
            return 1;

        return recursion3(n-2) + recursion3(n-1);
    }
}

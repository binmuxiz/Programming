// n보다 작거나 같은 모든 소수 출력

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("== solution1 ==");
        solution1(n);

        System.out.println("== solution2 ==");
        solution2(n);

    }

    public static void solution1(int n) {
        // 제곱근까지의 숫자로만 나누어 떨어지는지 확인
        // 그 이후의 숫자들로 나누어서 나눠떨어진다 있다 하더라도, 제곱근 이전에 나누는 수로 나누었을 때의 몫에 해당하기 때문.
        if (n == 1) return;

        List<Integer> list = getPrimeNumbers(n);
        for (int item : list) {
            System.out.println(item);
        }
    }

    private static List<Integer> getPrimeNumbers(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(Practice::isPrimeNumber)
                .boxed().collect(Collectors.toList());
    }

    private static boolean isPrimeNumber(int n) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)) // rangeClosed로 제곱근 값을 포함해야 함!!
                .allMatch(i -> n % i != 0);
    }

    public static void solution2(int n) {

        // 방법2) 에라토스테네스의 체
        // 시간복잡도 O(NloglogN)
        // n 크기 만큼의 배열을 할당해야 하므로 메모리가 많이 필요하다는 단점이 있다.
        // 10억이 소수인지 찾는 문제에서는 에라토스테네스의 체를 이용하기 어렵다.
        // 에라토스테네스의 체를 이용해야 하는 문제의 경우 Ndl 1,000,000 이내로 주어지는 경우가 많다.
        // 그렇게 하면 이론상 400만 번 정도의 연산으로 문제를 해결할 수 있으며, 메모리 또한 충분히 처리할 수 있는 크기만큼만 차지하게 된다.


        boolean[] primeNumArr = new boolean[n + 1];
        for (int i = 0; i < primeNumArr.length; i++) {
            primeNumArr[i] = true;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {

            if (primeNumArr[i]) { // i가 소수인 경우
                int j = 2;
                while (i * j <= n) {
                    primeNumArr[i * j] = false;
                    j++;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primeNumArr[i]) {
                System.out.println(i);
            }
        }
    }
}

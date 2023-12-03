package lamda_and_stream;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 특정 수를 입력 받고 해당 숫자보다 작거나 같은 모든 소수를 list로 만드는 스트림 작성
// 조건 : 반환된 스트림을 print문으로 출력
public class Practice2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int item : toPrimeNumberList(n)) {
            System.out.println(item);
        }
    }

    public static List<Integer> toPrimeNumberList(int num) {
         return IntStream.rangeClosed(2, num)
                 .filter(Practice2::isPrimeNumber)
                 .boxed().collect(Collectors.toList());
    }

    private static boolean isPrimeNumber(int num) {
        return IntStream.rangeClosed(2, (int)Math.sqrt(num))
                .allMatch(i -> num % i != 0);
    }
}

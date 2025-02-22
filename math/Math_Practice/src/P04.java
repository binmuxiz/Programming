
// 주어진 양의 정수가 행복한 수인지 판별하는 프로그램
// 행복한 수란, 각 자릿수의 제곱수를 더하는 과정을 반복하여 나온 결과가 1인 수이다.
// 행복한 수가 아니라면, 1에 도달하지 못하고 같은 수열이 반복된다.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P04 {
    public static void main(String[] args) {


        System.out.println(isHappyNumber2(19));
        System.out.println(isHappyNumber2(2));
        System.out.println(isHappyNumber2(61));
    }

    private static boolean isHappyNumber2(int n) {
        Set<Integer> set = new HashSet<>();
        int squareSum;

        while (set.add(n)) {
            squareSum = 0;

            while (n > 0) {
                squareSum += (n % 10) * (n % 10);
                n /= 10;
            }

            if (squareSum == 1) return true;
            n = squareSum;
        }
        return false;
    }

    private static boolean isHappyNumber(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        String nStr;

        while (true) {
            sum = 0;
            nStr = String.valueOf(n);

            for (int i = 0; i < nStr.length(); i++) {
                sum += Math.pow(Character.getNumericValue(nStr.charAt(i)), 2);
            }
            if (sum == 1) return true;
            if (map.containsKey(sum)) return false;

            map.put(sum, null);
            n = sum;
        }
    }

}

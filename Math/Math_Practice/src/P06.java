// 카탈랑 수의 n번쨰 값을 구하는 프로그램

public class P06 {
    public static void main(String[] args) {
        System.out.println(solution1(0));  // 1
        System.out.println(solution1(2)); // 2
        System.out.println(solution1(5)); // 42
        System.out.println(solution1(7)); // 429

        System.out.println();
        System.out.println(solution2(0));  // 1
        System.out.println(solution2(2)); // 2
        System.out.println(solution2(5)); // 42
        System.out.println(solution2(7)); // 429
    }

    // 반복구조 풀이
    private static int solution1(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j <= i; j++) {
                sum += nums[j] * nums[i - j];
            }
            nums[i + 1] = sum;
        }
        return nums[n];
    }

    // 재귀구조 풀이
    private static int solution2(int n) {
        int result = 0;

        if (n <= 1) return 1;

        for (int i = 0; i < n; i++) {
            result += solution2(i) * solution2(n - i - 1);
        }
        return result;
    }
}

package zero_base;/* 정수형 배열 nums와 target이 주어졌을 때,
nums에서 임의의 두 수를 더해 target을 구할 수 있는지 확인하는 프로그램을 작성하시오.
두 수의 합으로 target을 구할 수 있으면 해당 값의 index를 반환하고,
없는 경우 null을 반환하세요.

입출력 예시
nums : 7, 11, 5, 3
target: 10
출력 : 0, 3

nums: 8, 3, -2
target: 6
출력 : 0, 2

 */

import java.util.Arrays;
import java.util.Hashtable;

public class Practice2 {

    public static void main(String[] args) {
        int[] nums = {7, 11, 5, 3};
        System.out.println(Arrays.toString(solution(nums, 10)));

        nums = new int[]{8, 3, -2};
        System.out.println(Arrays.toString(solution(nums, 6)));

        nums = new int[]{1,2,3};
        System.out.println(Arrays.toString(solution(nums, 12)));
    }

    private static int[] solution(int[] nums, int target) {

        int[] result = new int[2];
        Hashtable<Integer, Integer> ht = new Hashtable<>(); // key는 nums의 값, value는 nums의 인덱스

        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(target - nums[i])) {
                result[0] = ht.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            ht.put(nums[i], i);
        }
        return null;
    }
}

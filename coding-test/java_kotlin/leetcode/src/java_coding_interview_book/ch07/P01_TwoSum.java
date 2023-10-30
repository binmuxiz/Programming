package java_coding_interview_book.ch07;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class P01_TwoSum {


    // 모든 조합을 일일이 확인해보는 무차별 대입 방식인 브루트 포스
    // 시간복잡도 O(N^2)
    // leetcode runtime : 45ms
    public static int[] solution1(int[] nums, int target) {

        // 입력값 배열을 처음부터 순회
        for (int i = 0; i < nums.length; i++) {
            // 입력값 배열을 그 다음부터 순회
            for (int j = i+1; j < nums.length; j++) {
                // 두 값의 합이 target과 일치하는 경우 정답으로 리턴
                if (target == nums[i] + nums[j])
                    return new int[]{i, j};
            }
        }

        // 항상 정답이 존재하므로 null이 리턴되는 경우는 없음
        return null;
    }

    // 투 포인터 이용 - 투 포인터는 주로 정렬된 입력값을 대상으로 한다.
    // nums는 정렬된 상태가 아니므로 정렬을 해야함. 하지만 정렬을 하면 인덱스가 바뀌기 때문에 불가능한 풀이
    public static int[] solution2(int[] nums, int target) {

        int i = 0;
        int j = nums.length-1;

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == target)
                return new int[]{i, j};
            // 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 한 칸 이동
            else if (sum > target)
                j--;
            // 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 한 칸 이동
            else
                i++;
        }
        return null;
    }

    // 3ms
    public static int[] solution3(int[] nums, int target) {

        Map<Integer, Integer> keys = new HashMap<>();

        // nums의 값이 key, 인덱스가 value인 map
        for (int i = 0; i < nums.length; i++) {
            keys.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            // target에서 nums의 값을 뺀 값이 map에 존재하고 그 값이 현재 인덱스가 아니면 정답 리턴
            if (keys.containsKey(j) && keys.get(j) != i) {
                return new int[]{i, keys.get(j)};
            }

        }
        return null;
    }
}





























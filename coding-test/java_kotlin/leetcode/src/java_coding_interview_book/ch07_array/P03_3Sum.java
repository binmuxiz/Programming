package java_coding_interview_book.ch07_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P03_3Sum {


    public static void main(String[] args) {
        P03_3Sum p = new P03_3Sum();
        System.out.println(p.twoPointer(new int[]{-1, 0, 1, 2, -1, -4}));

    }

    // 브루트포스 풀이방법 정렬 O(nlogn) + O(N^3) 시간초과
    public List<List<Integer>> brute_force(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                for (int k = j+1; k < nums.length; k++) {
                    if (k > j+1 && nums[k] == nums[k-1]) continue;

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> twoPointer(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left, right, sum;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left += 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }

                    left += 1;
                    right -= 1;
                }
            }
        }
        return result;
    }
}

package java_coding_interview_book.ch07_array;

import java.util.Arrays;

public class P04_ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i <= nums.length-2; i+=2) {
            result += nums[i];
        }
        return result;
    }

}

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12910_나누어떨어지는숫자배열 {

    public int[] solution(int[] arr, int divisor) {
        int[] result = new int[arr.length];
        int size = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                result[size++] = arr[i];
            }
        }
        if (size == 0) {
            return new int[]{-1};
        }
        return Arrays.stream(result).limit(size).sorted().toArray();
    }

    public int[] solution2(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();

        for (int item : arr) {
            if (item % divisor == 0) {
                result.add(item);
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        result.sort(null);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

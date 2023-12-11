package practice;

import java.util.Arrays;

public class Practice6 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        int[] result = new int[arr.length];
        int resultSize = 0;
        boolean isEqualVal = false;

        for (int i = 0; i < arr.length; i++) {
            isEqualVal = false;
            for (int j = 0; j < resultSize; j++) {
                if (arr[i] == result[j]) {
                    isEqualVal = true;
                }
            }
            if (!isEqualVal) {
                result[resultSize++] = arr[i];
            }
        }

        for (int i = 0; i < resultSize; i++) {
            System.out.println(result[i]);
        }
    }
}

package 코딩테스트입문;

import java.util.Arrays;

public class level0_배열자르기 {
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);

//        Arrays.stream(numbers, num1, num2+1).toArray()
    }
}

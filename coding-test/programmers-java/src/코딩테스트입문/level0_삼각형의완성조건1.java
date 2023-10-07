package 코딩테스트입문;

import java.util.Arrays;

public class level0_삼각형의완성조건1 {

    public int solution(int[] sides) {
        int max = sides[0];
        int maxIdx = 0;

        for (int i = 1; i < sides.length; i++) {
            if (max < sides[i]) {
                max = sides[i];
                maxIdx = i;
            }
        }

        int twoSum = sides[0] + sides[1] + sides[2] - sides[maxIdx];
        if (twoSum > sides[maxIdx]) return 1;
        else return 2;
    }

    public int solution2(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        answer = (sides[2] < sides[0] + sides[1]) ? 1 : 2;
        return answer;
    }

    // TODO 가장 긴 변을 찾을 필요 없이 삼각형은 한 변의 길이가 다른 두 변의 길이의 합보다 작다.
    public int solution3(int[] sides) {

        int A = sides[0] + sides[1];
        int B = sides[1] + sides[2];
        int C = sides[2] + sides[0];

//  (X)      answer = (A > sides[2]) || (B > sides[0]) || (C > sides[1]) ? 1 : 2;

        if(A <= sides[2] || B <= sides[0] || C <= sides[1]) return 2;
        else return 1;
    }
}
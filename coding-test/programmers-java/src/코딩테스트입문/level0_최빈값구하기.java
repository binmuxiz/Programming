package 코딩테스트입문;

public class level0_최빈값구하기 {
    public int solution(int[] array) {

        int[] nums_count = new int[1000];

        int max = 0;
        for (int e : array) {
            nums_count[e] = nums_count[e] + 1;
            max = (max < e) ? e : max;
        }

        int index = 0;
        int count = nums_count[0];

        for (int i = 1; i <= max; i++) {

            if (count < nums_count[i]) {
                index = i;
                count = nums_count[i];
            } else if (count == nums_count[i]) {
                index = -1;
            }
        }

        return index;
    }
}

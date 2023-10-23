package 코딩테스트입문;

public class level0_특이한정렬 {

    public int[] solution(int[] numlist, int n) {
        int TEN_THOUSAND = 10_000;
        int[][] dis_array = new int[2][TEN_THOUSAND];
        int[] answer = new int[numlist.length];

        for (int i = 0; i < numlist.length; i++) {
            int dis = (n - numlist[i]) * (n > numlist[i] ? 1 : -1);

            if (dis_array[0][dis] == 0)
                dis_array[0][dis] = numlist[i];
            else {
                if (dis_array[0][dis] >= numlist[i]) { // 중복된 원소는 존재하지 않으므로 같을 경우는 없음
                    dis_array[1][dis] = numlist[i];
                }
                else {
                    dis_array[1][dis] = dis_array[0][dis];
                    dis_array[0][dis] = numlist[i];
                }
            }
        }

        for (int i = 0, j = 0; j < numlist.length && i < TEN_THOUSAND; i++) {
            if (dis_array[0][i] != 0) {
                answer[j++] = dis_array[0][i];

                if (dis_array[1][i] != 0)
                    answer[j++] = dis_array[1][i];
            }
        }

        return answer;
    }
}

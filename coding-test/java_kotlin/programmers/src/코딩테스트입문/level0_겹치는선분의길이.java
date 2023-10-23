package 코딩테스트입문;

public class level0_겹치는선분의길이 {

    public int solution(int[][] lines) {
        int answer = 0;
        int min = lines[0][0], max = lines[0][1];

        for (int i = 1; i < lines.length; i++) {
            min = (min > lines[i][0]) ? lines[i][0] : min;
            max = (max < lines[i][1]) ? lines[i][1] : max;
        }
        int[] scores = new int[max-min];

        for (int i = 0; i < lines.length; i++) {
            int begin = lines[i][0] - min;
            int end = lines[i][1] - lines[i][0];

            for (int j = begin; j < begin+end; j++) {
                scores[j] = scores[j] + 1;
            }
        }
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > 1) answer++;
        }

        return answer;
    }
}

package 코딩테스트입문;

public class level0_평행 {
    public int solution(int[][] dots) {
        int answer = 0;

        for (int i = 1; i < dots.length; i++) {
            int idx1 = (i == 1) ? 2 : 1;
            int idx2 = (i == 3) ? 2 : 3;

            int y1 = dots[0][1] - dots[i][1];
            int x1 = dots[0][0] - dots[i][0];
            int y2 = dots[idx1][1] - dots[idx2][1];
            int x2 = dots[idx1][0] - dots[idx2][0];

            if ((double)y1/x1 == (double)y2/x2) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}

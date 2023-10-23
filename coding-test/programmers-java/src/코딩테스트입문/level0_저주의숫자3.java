package 코딩테스트입문;

public class level0_저주의숫자3 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;
            while (answer % 3 == 0 || (answer + "").contains("3")) {
                answer++;
            }
        }

        return answer;
    }
}

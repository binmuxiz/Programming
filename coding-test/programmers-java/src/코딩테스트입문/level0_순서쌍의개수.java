package 코딩테스트입문;

public class level0_순서쌍의개수 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            answer = (n % i == 0) ? answer + 1 : answer;
        }

        return answer;
    }
}

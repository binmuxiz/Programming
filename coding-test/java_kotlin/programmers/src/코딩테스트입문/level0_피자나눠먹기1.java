package 코딩테스트입문;

public class level0_피자나눠먹기1 {
    public int solution(int n) {
        int answer = 0;

        answer = n / 7;
        if (n % 7 > 0) answer += 1;
        return answer;
    }
}

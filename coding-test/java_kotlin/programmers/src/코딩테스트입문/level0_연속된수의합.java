package 코딩테스트입문;

public class level0_연속된수의합 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        answer[0] = total/num - num/2;
        if (num%2==0) answer[0] += 1;

        for (int i = 1; i < num; i++) {
            answer[i] = answer[i-1] + 1;
        }

        return answer;
    }
}

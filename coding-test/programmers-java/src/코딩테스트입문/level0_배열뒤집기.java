package 코딩테스트입문;

public class level0_배열뒤집기 {
    public int[] solution(int[] num_list) {
        int maxIdx = num_list.length - 1;
        int[] answer = new int[maxIdx + 1];

        for (int i = 0; i <= maxIdx; i++) {
                // maxIdx와의 거리
            answer[maxIdx - i] = num_list[i];
        }
        return answer;
    }
}

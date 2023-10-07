package 코딩테스트입문;

public class level0_옹알이1 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] WORDS = new String[]{"aya","ye","woo","ma"}; // 발음 가능한 문자열

        for (String bab : babbling) {
            int len = bab.length();
            for (String str : WORDS) {
                if (bab.contains(str)) len -= str.length();
            }
            if (len == 0) answer++;
        }

        return answer;
    }
}

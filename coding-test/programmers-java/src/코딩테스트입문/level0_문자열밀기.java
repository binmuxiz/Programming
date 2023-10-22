package 코딩테스트입문;

public class level0_문자열밀기 {
    public int solution(String A, String B) {
        int answer = -1;
        int len = A.length();
        String str = A;

        for (int i = 0; i < len; i++) {
            if (str.equals(B)) {
                answer = i;
                break;
            }
            str = str.charAt(len - 1) + str.substring(0, len - 1);
        }
        return answer;
    }
}

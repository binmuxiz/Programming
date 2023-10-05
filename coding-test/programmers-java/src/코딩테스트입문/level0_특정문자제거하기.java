package 코딩테스트입문;

public class level0_특정문자제거하기 {

    public String solution(String my_string, String letter) {
        String answer = "";

        // 1
//        for (String i : my_string.split("")) {
//            answer = (i.equals(letter)) ? answer : answer + i;
//        }

        // 2
//        answer = my_string.replace(letter, "");

        // 3
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArr = my_string.toCharArray();
        for (char ch : charArr) {
            if (ch != letter.charAt(0)) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}

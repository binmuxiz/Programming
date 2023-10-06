package 코딩테스트입문;

import java.util.Arrays;

public class level0_문자열뒤집기 {
    public String solution(String my_string) {

        StringBuilder sb = new StringBuilder();

        // 1
//        char[] charArr = my_string.toCharArray();
//
//        for (int i = charArr.length - 1; i >= 0; i--) {
//            sb.append(charArr[i]);
//        }
//
        // 2
//        for (int i = my_string.length() - 1; i >= 0; i--) {
//            sb.append(my_string.charAt(i));
//        }

        //3
        sb.append(my_string).reverse();

        return sb.toString();

    }
}

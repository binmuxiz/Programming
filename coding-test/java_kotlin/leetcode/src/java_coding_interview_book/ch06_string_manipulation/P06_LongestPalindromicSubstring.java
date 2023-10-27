package java_coding_interview_book.ch06_string_manipulation;

public class P06_LongestPalindromicSubstring {

    static String str;
    static int head;
    static int maxLen;

    public static void main(String[] args) {
        solution2("12");
    }

    // 15ms
    public static String solution2(String s) {

        str = s;
        int len = str.length();
        if (len == 1) return str;

        for (int i = 0; i < len-1; i++) {
            extendTwoPointer(i, i + 1);
            extendTwoPointer(i, i + 2);
        }
        return str.substring(head, head + maxLen);
    }

    private static void extendTwoPointer(int h, int t) {

        while (h >= 0 && t < str.length() && str.charAt(h) == str.charAt(t)) {
            h--;
            t++;
        }

        int len = t - h - 1;
        if (len > maxLen) {
            maxLen = len;
            head = h + 1;
        }
    }



    // 시간 초과
    public static String solution(String str) {

        for (int i = str.length(); i > 0; i--) {
            for (int j = 0; j + i - 1 < str.length(); j++) {
                String substring = str.substring(j, j + i);
                String reverse = new StringBuffer(substring).reverse().toString();

                if (substring.equals(reverse)) {
                    return substring;
                }
            }
        }
        return "";
    }
}

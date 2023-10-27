package java_coding_interview_book.ch06_string_manipulation;

// https://leetcode.com/problems/valid-palindrome/
public class P01_ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(solution1("1    "));
    }

    // 2ms
    public static boolean solution1(String s) {

        int h = 0;
        int t = s.length() - 1;

        while (h < t) {
            char ch1 = s.charAt(h);
            char ch2 = s.charAt(t);

            if (!Character.isLetterOrDigit(ch1)) {
                h++;
                continue;
            } else if (!Character.isLetterOrDigit(ch2)) {
                t--;
                continue;
            }
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2))
                return false;

            h++; t--;
        }

        return true;
    }

    // 23ms
    public static boolean solution2(String s) {

        String filteredStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversedStr = new StringBuilder(filteredStr).reverse().toString();
        return filteredStr.equals(reversedStr);
    }

}

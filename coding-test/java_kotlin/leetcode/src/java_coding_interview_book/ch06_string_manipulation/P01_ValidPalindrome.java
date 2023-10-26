package java_coding_interview_book.ch06_string_manipulation;

// https://leetcode.com/problems/valid-palindrome/
public class P01_ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(solution1("1    "));
    }

    public static boolean solution1(String s) {

        boolean answer = true;
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                answer = false;
                break;
            }
            start++;
            end--;
        }
        return answer;
    }

    public static boolean solution2(String s) {

        String filteredStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversedStr = new StringBuilder(filteredStr).reverse().toString();
        return filteredStr.equals(reversedStr);
    }

}

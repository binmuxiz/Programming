package java_coding_interview_book;

public class P01_ValidPalindrome {

    public static boolean isPalindrome(String s) {

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

    public static void main(String[] args) {
        System.out.println(isPalindrome("1    "));
    }
}

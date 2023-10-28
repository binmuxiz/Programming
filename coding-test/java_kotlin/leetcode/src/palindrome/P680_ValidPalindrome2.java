package palindrome;

// https://leetcode.com/problems/valid-palindrome-ii/
public class P680_ValidPalindrome2 {

    public static void main(String[] args) {
        solution("aba");
        solution("abca");
        solution("abc");
    }

    public static boolean solution2(String s) {

        return isPalindrome(s, 0, s.length()-1, 1);
    }

    private static boolean isPalindrome(String s, int h, int t, int cnt) {

        while (h < t) {
            if (s.charAt(h) != s.charAt(t)) {
                if (cnt < 1) return false;
                return isPalindrome(s, h + 1, t, cnt-1) || isPalindrome(s, h, t - 1, cnt-1);
            }
            h++; t--;
        }

        return true;
    }

    public static boolean solution(String s) {

        int h = 0;
        int t = s.length()-1;
        int maxDeleteCnt = 1;

        while (h < t) {

            if (s.charAt(h) == s.charAt(t)) {
                h++;
                t--;

            } else if (maxDeleteCnt > 0 && h+1 <= t && s.charAt(h+1) == s.charAt(t)) {
                System.out.println("delete character -> " + s.charAt(h));
                h++;
                maxDeleteCnt--;

            } else if (maxDeleteCnt > 0 && h <= t-1 && s.charAt(h) == s.charAt(t-1)) {
                System.out.println("delete character -> " + s.charAt(t));
                t--;
                maxDeleteCnt--;

            } else {
                return false;
            }
        }

        return true;
    }
}

package palindrome.easy;

public class P409_LongestPalindrome {

    public int longestPalindrome(String s) {
        int output = 0;

        int[] counts = new int[26*2];
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                counts[ch-'a']++;
            } else {
                counts[26 + ch-'A']++;
            }
        }

        boolean flag = false;

        for (int i = 0; i < counts.length; i++) {

            if (counts[i] % 2 == 0)
                output += counts[i];
            else {
                output += (counts[i] - 1);
                flag = true;
            }
        }

        if (flag) output++;

        return  output;
    }

    public int longestPalindrome2(String s) {
        int output = 0;
        int[] lowerCounts = new int[26];
        int[] upperCounts = new int[26];

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lowerCounts[ch-'a']++;
            } else {
                upperCounts[ch-'A']++;
            }
        }

        int x = 0;
        for (int i = 0; i < 26; i++) {
            output += (lowerCounts[i] - lowerCounts[i] % 2) + (upperCounts[i] - upperCounts[i] % 2);
            if (lowerCounts[i] % 2 == 1 || upperCounts[i] % 2 == 1) {
                x = 1;
            }
        }

        return  output + x;
    }
}

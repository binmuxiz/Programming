package palindrome.medium;

import java.util.ArrayList;
import java.util.List;

public class P131_PalindromePartitioning {

    List<List<String>> output = new ArrayList<>();

    public List<List<String>> partition(String s) {

        while (true) {
            List<String> list = new ArrayList<>();

            while (true) {

                String subStr = null;

                if (isPalindrome(subStr)) {
                    list.add(subStr);
                }
            }
//            output.add(list);
        }

    }

    public boolean isPalindrome(String str) {
        if (str.length() == 1)
            return true;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }
}

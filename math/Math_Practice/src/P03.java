import java.util.ArrayList;
import java.util.Arrays;

public class P03 {

    public static void main(String[] args) {
        System.out.println(solution1("ab", "adbak"));
        System.out.println(solution1("ac", "car"));
        System.out.println(solution1("ak", "aabbkk"));

        System.out.println(solution2("ab", "adbak"));
        System.out.println(solution2("ac", "car"));
        System.out.println(solution2("ak", "aabbkk"));

    }

    public static boolean solution1(String s1, String s2) {
        int n = s1.length();
        int r = n;
        ArrayList<String> result = new ArrayList<>();
        permutation(s1.toCharArray(), 0, n, r, new boolean[n], new char[r], result);

        for (String str : result) {
            if (s2.contains(str)) {
                return true;
            }
        }
        return false;
    }

    private static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list) {
        if (depth == r) {
            list.add(new String(out));
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }

    // #2. 문제 규칙 찾아 해결
    public static boolean solution2(String s1, String s2) {
        final int ALPHABET = 26;

        if (s1.length() > s2.length())
            return false;

        int[] counts = new int[ALPHABET];
//        for (char ch : s1.toCharArray()) {
//            counts[ch - 'a']++;
//        }
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;

            if (i - s1.length() > -1) {
                counts[s2.charAt(i - s1.length()) - 'a']++;
            }

            boolean isZero = true;
            for (int j = 0; j < ALPHABET; j++) {
                if (counts[j] != 0) {
                    isZero = false;
                    break;
                }
            }
            if (isZero) {
                return true;
            }
        }
        return false;
    }
}

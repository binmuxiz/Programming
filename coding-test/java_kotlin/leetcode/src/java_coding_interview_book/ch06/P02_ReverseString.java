package java_coding_interview_book.ch06;

public class P02_ReverseString {

    public static void main(String[] args) {
        solution1(new char[]{'h','e','l','l','o'});
    }

    public static void solution1(char[] s) {

        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}

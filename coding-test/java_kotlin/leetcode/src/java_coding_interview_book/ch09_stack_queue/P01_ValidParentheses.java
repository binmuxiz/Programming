package java_coding_interview_book.ch09_stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P01_ValidParentheses {
    // 2ms ㅅㄱ O(N) ㄱㄱ O(N)
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || map.get(ch) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

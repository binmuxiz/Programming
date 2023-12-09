package ex2;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackMain {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(1);
        stack.add(2);
        stack.addFirst(3);
        for (int i = 0; i < 4; i++) {
            System.out.println(stack.remove());
        }
    }
}

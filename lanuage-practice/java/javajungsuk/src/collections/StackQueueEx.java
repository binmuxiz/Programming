package collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new LinkedList(); // Interface Queue의 구현체인 (doubly)LinkedList 사용

        stack.push(1);
        stack.push(2);
        Object obj = stack.push(3);

        boolean add = stack.add(1);
        stack.addElement(3);

        int search = stack.search(2);
        System.out.println(search); // 4     top이 1, top에서 부터 셈

        System.out.println("==Stack==");
        while (!stack.empty()) {
            System.out.println(stack.pop());

        }

        boolean add1 = queue.add(0);        // 저장공간이 부족하면 IllegalStateException 발생
        boolean offer = queue.offer(1); // 저장 실패 시 false 반환
        queue.offer(2);
        queue.offer(3);
        Object peek = queue.peek();
        Object element = queue.element();
        Object remove = queue.remove();
        Object poll = queue.poll();

        System.out.println("==Queue");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());

        }
    }
}

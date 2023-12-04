package java_coding_interview_book.ch08_linked_list;

import org.w3c.dom.ls.LSInput;

import java.util.*;

public class P01_PalindromeLInkedList {

    // Runner를 이용한 풀이 2 : 3ms, 시간복잡도 O(N), 공간복잡도 O(1)
    public boolean isPalindrome4(ListNode head) {
        ListNode fastR = head;
        ListNode slowR = head;
        ListNode revHead = head;

        // O(N/2)
        while(true) {
            if (fastR == null) { // even
                break;
            }

            if (fastR.next == null) { // odd
                slowR = slowR.next;
                break;
            }

            // reversal
            ListNode temp = revHead;
            revHead = slowR;
            slowR = slowR.next;
            revHead.next = temp;
        }

        // O(N/2)
        while (slowR != null) {
            if (slowR.val != revHead.val) {
                return false;
            }
            revHead = revHead.next;
            slowR = slowR.next;
        }
        return true;
    }

    // Runner를 이용한 풀이 : 7ms, 시간복잡도 O(N), 공간복잡도 O(N)
    public boolean isPalindrome3(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode fastR = head;
        ListNode slowR = head;

        // O(N/2)
        while(fastR != null && fastR.next != null) {
            deque.addLast(slowR);

            fastR = fastR.next.next;
            slowR = slowR.next;
        }

        if (fastR != null && fastR.next == null) {
            slowR = slowR.next;
        }

        // O(N/2)
        while (!deque.isEmpty()) {
            if (deque.removeLast().val != slowR.val) {
                return false;
            }
            slowR = slowR.next;
        }
        return true;
    }

    // Deque를 이용한 풀이 : 9ms, 시간복잡도 O(N+N/2), 공간복잡도 O(N)
    public boolean isPalindrome2(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();

        ListNode cur = head;
        while(cur != null) {
            deque.addLast(cur);
            cur = cur.next;
        }

        while (deque.size() > 1) {
            if (deque.removeFirst().val != deque.removeLast().val) {
                return false;
            }
        }
        return true;
    }

    // 스택을 이용한 풀이 : 14ms, 시간복잡도 O(2N), 공간복잡도 O(N)
    public boolean isPalindrome1(ListNode head) {
        // 이 자료형은 사용 지양
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while(!stack.isEmpty()) {
            if (cur.val != stack.pop().val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    private static class ListNode<E> {
        int val;
        ListNode<E> next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

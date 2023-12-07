package java_coding_interview_book.ch08_linked_list;

import java.math.BigInteger;
import java.util.List;

public class P04_AddTwoNumbers {


    // 2ms 시간복잡도 O(N) 공간복잡도 O(N)
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode root = node;

        int sum, carry = 0, remainder;

        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            // 첫번째 연결리스트 합산 및 진행
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            remainder = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            node.next = new ListNode(remainder);
            node = node.next;
        }
        return root.next;
    }

    // 1ms 시간복잡도 O(N) 공간복잡도 O(N)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode cur = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum;

            if (l1 == null && l2 == null) {
                cur.next = new ListNode(carry);
                break;
            }

            if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                sum = l2.val;
                l2 = l2.next;
            } else {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            sum += carry;

            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            if (result != null) {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            } else {
                result = new ListNode(sum % 10);
                cur = result;
            }
        }
        return result;
    }

    // 18ms
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        // 역순 뒤집기
        l1 = reverse(l1);
        l2 = reverse(l2);

        // 더하기
        BigInteger bigInteger = toBigInt(l1).add(toBigInt(l2));

        // 노드 연결로 만들기
        return toReversedLinkedList(bigInteger);
    }

    private ListNode reverse(ListNode node) {
        // 반복구조로 역순 뒤집기
        ListNode prev = null;
        ListNode next;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    private BigInteger toBigInt(ListNode node) {
        String val = "";
        while (node != null) {
            val += node.val;
            node = node.next;
        }
        return new BigInteger(val);
    }

    private ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null;
        ListNode node = null;

        for (char c : String.valueOf(val).toCharArray()) {
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }

        return node;
    }
}

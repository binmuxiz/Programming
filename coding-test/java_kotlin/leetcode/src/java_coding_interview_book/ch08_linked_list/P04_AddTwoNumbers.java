package java_coding_interview_book.ch08_linked_list;

public class P04_AddTwoNumbers {

    // 1ms 시간복잡도 O(N) 공간복잡도 O(N)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode cur = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum;

            if (l1 == null && l2 == null) {
                cur.next = new ListNode(carry);
                break;
            }

            if (l1 == null) {
                sum = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val;
                l1 = l1.next;
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
}

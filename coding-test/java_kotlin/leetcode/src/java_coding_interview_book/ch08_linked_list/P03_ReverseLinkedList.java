package java_coding_interview_book.ch08_linked_list;

public class P03_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        return recursive(head, null);
    }

    // 재귀 구조 0ms 시간복잡도 O(N), 공간복잡도 O(N)
    public ListNode recursive(ListNode node, ListNode prev) {
        if (node == null) return prev;

        ListNode next = node.next;
        node.next = prev;
        return recursive(next, node);
    }

    // 반복 구조 0ms 시간복잡도 O(N) 공간복잡도 O(1)
    public ListNode iterative(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

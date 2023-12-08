package java_coding_interview_book.ch08_linked_list;

public class P07_ReverseLinkedList2 {

    // 0ms ㅅㄱO(N) ㄱㄱO(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode start = root;

        for (int i = 0; i < left; i++){
            start = start.next;
        }
        ListNode end = start.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = temp;
        }

        return root.next;
    }
}

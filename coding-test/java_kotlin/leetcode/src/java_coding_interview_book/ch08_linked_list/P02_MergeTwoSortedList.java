package java_coding_interview_book.ch08_linked_list;

public class P02_MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        mergeTwoLists1(node1, node4);
        mergeTwoLists1(node1, node4);
    }


    // 재귀구조로 구현. 0ms 시간복잡도 O(N + N) 공간복잡도 O(N)
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }
    // 0ms 시간복잡도 O(N+N) 공간복잡도 O(N)
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode result;
        ListNode cur;

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val <= list2.val) {
                result = list1;
                list1 = list1.next;
            } else {
                result = list2;
                list2 = list2.next;
            }
            cur = result;
        }

        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 == null) {
            cur.next = list2;
        } else if (list2 == null) {
            cur.next = list1;
        }
        return result;
    }
}


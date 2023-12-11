package practice;

import java.util.Deque;

public class Practice3 {
    public static LinkedList reverseBetween(LinkedList list, int left, int right) {
        Node start = list.head;
        Node cur = list.head;

        for (int i = 0; i < left; i++) {
            start = cur;
            cur = cur.next;
        }


        return list;
    }

    public static void main(String[] args) {

    }
}

package practice;

public class Practice2 {

    public static boolean isPalindrome(LinkedList list) {
        Node revHead = list.head;
        Node fast = list.head;
        Node slow = list.head;

        while (true) {
            if (fast == null) { // even
                break;
            }
            if (fast.next == null) { // odd
                slow = slow.next;
                break;
            }
            fast = fast.next.next;

            // reversal
            Node temp = revHead;
            revHead = slow;
            slow = slow.next;
            revHead.next = temp;
        }

        while (slow != null) {
            if (slow.data != revHead.data) {
                return false;
            }
            slow = slow.next;
            revHead = revHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addData(1);
        list.addData(3);
        list.addData(5);
        list.addData(7);
        list.addData(9);
        System.out.println(isPalindrome(list));

        LinkedList list2 = new LinkedList();
        list2.addData(3);
        list2.addData(5);
        list2.addData(5);
        list2.addData(3);
        System.out.println(isPalindrome(list2));

        LinkedList list3 = new LinkedList();
        list3.addData(1);
        list3.addData(3);
        list3.addData(5);
        list3.addData(1);
        System.out.println(isPalindrome(list3));

        LinkedList list4 = new LinkedList();
        list4.addData(1);
        list4.addData(2);
        System.out.println(isPalindrome(list4));

        LinkedList list5 = new LinkedList();
        list5.addData(1);
        list5.addData(1);
        System.out.println(isPalindrome(list5));

        LinkedList list6 = new LinkedList();
        list6.addData(1);
        System.out.println(isPalindrome(list6));
    }
}

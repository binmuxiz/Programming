package practice;

public class Practice1 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addData(1);
        list.addData(3);
        list.addData(3);
        list.addData(1);
        list.addData(4);
        list.addData(2);
        list.addData(4);
        list.addData(2);

        list.showData();

        list = removeDuplicateItem(list);
        list.showData();
    }
    private static LinkedList removeDuplicateItem(LinkedList list) {
        LinkedList newList = new LinkedList();

        Node cur = list.head;

        while (cur != null) {
            if (!newList.findData(cur.data)) {
                newList.addData(cur.data);
            }
            cur = cur.next;
        }
        return newList;
    }
}


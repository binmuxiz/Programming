package _03_DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addData(1, null);
        list.addData(2, null);
        list.addData(3, null);
        list.addData(4, null);
        list.addData(23, 3);
        list.addData(0, 1);

        list.showData();

        list.removeData(1);
        list.removeData(0);
        list.removeData(4);

        list.showData();
        list.showDataFromTail();

        list.removeData(2);
        list.removeData(23);
        list.removeData(3);

        list.showData();
    }
}



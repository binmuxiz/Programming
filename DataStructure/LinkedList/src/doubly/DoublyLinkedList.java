package doubly;

public class DoublyLinkedList<E> {
    Node<E> head;
    Node<E> tail;

    public DoublyLinkedList() {}

    public boolean isEmpty() {
        return this.head == null;
    }

    // beforeData 앞에 추가, beforeData가 null이면 맨 뒤에 추가
    public void addData(E data, E beforeData) {
        if (isEmpty()) {
            this.head = new Node(data);
            this.tail = head;
        }
        else if (beforeData == null) {
            this.tail.next = new Node(data);
            this.tail = this.tail.next;
        }
        else {
            Node prev = this.head;
            Node cur = this.head;

            while (cur != null) {
                if (cur.data.equals(beforeData)) {
                    if (cur == this.head) {
                        this.head = new Node<>(data, null, this.head);
                        this.head.next.prev = this.head;
                    } else {
                        Node newNode = new Node(data, prev, cur);
                        prev.next = newNode;
                        cur.prev = newNode;
                    }
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(E data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node prev = this.head;
        Node cur = this.head;

        while (cur != null) {
            if (cur.data.equals(data)) {
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                }
                else if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;

                } else if (cur == this.tail) {
                    this.tail = prev;
                    this.tail.next = null;

                } else {
                    prev.next = cur.next;
                    cur.next.prev = prev;
                }
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void showDataFromTail() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.tail;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }
}

class Node<E> {
    E data;
    Node prev;
    Node next;

    public Node(E data) {
        this.data = data;
    }

    public Node(E data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
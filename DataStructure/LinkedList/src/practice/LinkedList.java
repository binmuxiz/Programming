package practice;

class LinkedList {
    Node head;

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addData(int data) {
        if (this.isEmpty()) {
            this.head = new Node(data);
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(data);
    }

    public void showData() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public boolean findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return false;
        }
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}

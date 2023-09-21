package DataStructure.SinglyLinkedList;

class SinglyLinkedList<E>
{
    Node<E> head;
    int size;

    SinglyLinkedList()
    {
        this.head = null;
        this.size = 0;
    }

    void addNext(E data, Node<E> prevNode) {

        Node<E> newNode = new Node<>(data, prevNode.getNext());
        prevNode.setNext(newNode);
        size++;
    }

    void addFirst(E data)
    {
        head = new Node<E>(data, head);
        size++;
    }

    void removeNext(Node<E> prevNode)
    {
        Node<E> now = prevNode.getNext();
        prevNode.setNext(now.getNext());
        now.setData(null);
        now.setNext(null);
        size--;
    }

    void removeFirst()
    {
        Node<E> node = head;
        head = head.getNext();
        node.setData(null);
        node.setNext(null);
        size--;
        return;
    }

    int size() { return size; }

    boolean isEmpty() { return size==0; }
}

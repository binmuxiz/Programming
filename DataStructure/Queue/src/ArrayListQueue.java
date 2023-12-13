// ArrayList를 이용한 Queue 구현

import java.util.ArrayList;

public class ArrayListQueue<E> {
    ArrayList<E> list;

    public ArrayListQueue() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void add(E data) {
        list.add(data);
    }

    public E poll() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        E data = this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public E peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        E data = this.list.get(0);
        return data;
    }

    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
        }

        System.out.println(this.list);
    }
}


class Main {
    public static void main(String[] args) {
        ArrayListQueue<Integer> queue = new ArrayListQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        queue.printQueue();

        System.out.println(queue.peek());

        queue.poll();
        queue.poll();
        queue.poll();
        queue.printQueue();

        queue.poll();
        queue.printQueue();

        queue.poll();
    }
}
// 배열을 이용한 원형 큐 구현

public class ArrayCircularQueue<E> {
    Integer[] queue;
    int front;
    int rear;
    int elementCnt;

    public ArrayCircularQueue(int size) {
        this.queue = new Integer[size];
        this.front = 0;
        this.rear = -1;
        this.elementCnt = 0;
    }

    public boolean isEmpty() {
        return this.elementCnt == 0;
    }

    public boolean isFull() {
        return this.elementCnt == this.queue.length;
    }

    public void enqueue(Integer data) {
        if (this.isFull()) {
            System.out.println("Queue is full");
            return;
        }

        this.rear = (this.rear + 1) % this.queue.length;
        this.queue[this.rear] = data;
        this.elementCnt++;
    }

    public Integer dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        Integer data = this.queue[this.front];
        this.queue[this.front] = null;
        this.elementCnt--;

        if (this.isEmpty()) {
            this.front = 0;
            this.rear = -1;
        } else {
            this.front = (this.front + 1) % this.queue.length;
        }
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return this.queue[this.front];
    }

    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }


        for (int i = this.front, cnt = 0; cnt < this.elementCnt; i = (i + 1) % this.queue.length, cnt++) {
            System.out.print(this.queue[i] + " ");
        }

        System.out.println();
    }
}

class Main2 {
    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5); // queue is full
        queue.printQueue();     // 1 2 3 4

        System.out.println(queue.peek()); // 1

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();  // 4

        queue.enqueue(5);
        queue.enqueue(6);
        queue.printQueue(); // 4 5 6

        queue.enqueue(7);
        queue.printQueue(); // 4 5 6 7

        queue.enqueue(8); // queue is full

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();

        queue.dequeue(); // queue is empty
    }
}

package ex1;

public class MyStack {
    MyNode last;

    public MyStack() {
        this.last = null;
    }

    public void push(int item) {
        this.last = new MyNode(item, this.last);
    }

    public int pop() {
        int item = this.last.item;
        this.last = this.last.next;
        return item;
    }
}

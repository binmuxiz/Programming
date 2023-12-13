// ArrayList를 이용한 Stack 구현

import java.util.ArrayList;

class MyStack {
    ArrayList list;

    MyStack() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = (int) this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = (int) this.list.get(this.list.size() - 1);
        return data;
    }

    public void printStack() {
        System.out.println(this.list);
    }
}


public class MyStackMain {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.printStack();

        System.out.println(myStack.peek());

        myStack.pop();
        myStack.printStack();

    }
}
// 배열을 이용한 스택 구현

class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        this.arr = new int[size];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.arr.length - 1;
    }

    public void push(int data) {
        if (this.isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        this.arr[++this.top] = data;
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = this.arr[this.top];
        this.top--;
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = this.arr[top];
        return data;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class MyStack2Main {

    public static void main(String[] args) {
        MyStack2 myStack2 = new MyStack2(5);
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);
        myStack2.push(4);
        myStack2.push(5);
        myStack2.push(6);

        myStack2.printStack();

        System.out.println(myStack2.peek());

        myStack2.pop();
        myStack2.pop();
        myStack2.pop();
        myStack2.pop();
        myStack2.printStack();

        myStack2.pop();
        myStack2.pop();



    }
}

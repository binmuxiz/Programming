package ex1;

public class MyStackMain {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.last.item);

        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
    }
}

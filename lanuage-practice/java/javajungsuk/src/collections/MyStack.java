package collections;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {

    public Object push(Object item) {
        addElement(item);
        return item;
    }

    public Object peek() {
        int len = size();
        if (len == 0)
            throw new EmptyStackException();

        return elementAt(len - 1);
    }

    public Object pop() {
        Object item = peek();
        removeElementAt(size() - 1);

        return item;
    }

    public boolean empty() {
        return size() == 0;
    }

    public int search(Object item) {
        int idx = lastIndexOf(item);
        if (idx >= 0) {
            return size() - idx;  // stack은 맨 위에 저장된 객체의 index를 1로 정의한다.
        }
        return -1;
    }
}

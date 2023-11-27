package java_coding_interview_book.ch11_hashtable;

// solution1 : Separate chaining
public class MyHashMap_LinearProbing {
    Node[] elements;
    int elementCount;
    final int INITIAL_SIZE = 100000;

    public MyHashMap_LinearProbing() {
        elements = new Node[INITIAL_SIZE];
        elementCount = 0;
    }

    private int hash(int key) {
        return key % elements.length;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if (elements[idx] == null) {
            elements[idx] = new Node(key, value);
            elementCount++;
            return;
        }
        boolean isContainsKey = false;
        while (elements[idx] != null) {
            if (elements[idx].key == key) {
                isContainsKey = true;
                elements[idx].value = value;
                break;
            }
            idx = (idx + 1) % elements.length;
        }
        if (!isContainsKey) {
            elements[idx] = new Node(key, value);
            elementCount++;
        }
    }

    // idx번째에 요소 없으면 null 체크,,,!!
    public int get(int key) {
        int idx = hash(key);
        if (elements[idx] == null)
            return -1;
        else if (elements[idx].key == key)
            return elements[idx].value;

        int newIdx = idx + 1;
        while (newIdx != idx) {
            if (elements[newIdx] == null)  // 조건문 순서 중요함 여기선!
                return -1;
            else if (elements[newIdx].key == key)
                return elements[newIdx].value;

            newIdx = (newIdx + 1) % elements.length;
        }
        return -1;
    }


    public void remove(int key) {
        int idx = hash(key);
        if (elements[idx] == null)
            return;
        else if (elements[idx].key == key) {
            elements[idx] = null;
        }

        int newIdx = idx + 1;
        while (newIdx != idx) {
            if (elements[newIdx] == null)
                return;
            else if (elements[newIdx].key == key) {
                elements[newIdx] = null;
            }
            newIdx = (newIdx + 1) % elements.length;
        }
    }
}


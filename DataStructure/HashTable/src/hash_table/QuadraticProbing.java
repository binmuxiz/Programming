package hash_table;

// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)
class MyHashTable3 extends MyHashTable {

    MyHashTable3(int length) {
        super(length);
    }

    @Override
    public void setValue(int key, int value) {
        int idx = this.getHash(key);

        if (this.elementCount == this.table.length) {
            System.out.println("Hash Table is full!");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = value;
        } else {
            int newIdx = idx;
            for (int i = 0; ; i++) {
                newIdx = (newIdx + (int)Math.pow(2, i)) % this.table.length;
                if (this.table[newIdx] == null)
                    break;
            }
            this.table[newIdx] = value;
        }
        this.elementCount++;
    }
}

public class QuadraticProbing {

    public static void main(String[] args) {

        MyHashTable3 ht = new MyHashTable3(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(4, 40);
        ht.printHashTable();

        ht.setValue(1, 100);
        ht.printHashTable();

        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.setValue(1, 400);
        ht.printHashTable();
    }
}

package _15_HashTable;

// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)
public class _02_QuadraticProbing extends MyHashTable {

    _02_QuadraticProbing(int length) {
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

class QuadraticProbingMain {

    public static void main(String[] args) {

        _02_QuadraticProbing ht = new _02_QuadraticProbing(11);
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

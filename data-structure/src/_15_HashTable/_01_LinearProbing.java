package _15_HashTable;

// 해시 충돌 해결 - 개방 주소법 (선형 탐사법)
class _01_LinearProbing extends MyHashTable {

    _01_LinearProbing(int length) {
        super(length);
    }

    public void setValue(int key, int value) {
        int idx = this.getHash(key);

        if (this.elementCount == this.table.length) {
            System.out.println("Hash Table is full!");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = value;
        } else { // 충돌
            int newIdx = idx;
            while (true) {
                newIdx = (newIdx + 1) % this.table.length;
                if (this.table[newIdx] == null)
                    break;
            }
            this.table[newIdx] = value;
        }
        this.elementCount++;
    }
}


class LinearProbingMain {

    public static void main(String[] args) {
        _01_LinearProbing ht = new _01_LinearProbing(5);
        ht.setValue(1, 1);
        ht.setValue(3, 3);
        ht.printHashTable();

        ht.setValue(1, 10);
        ht.printHashTable();

        ht.setValue(1, 20);
        ht.setValue(1, 30);
        ht.setValue(1, 40);
        ht.printHashTable();
    }
}

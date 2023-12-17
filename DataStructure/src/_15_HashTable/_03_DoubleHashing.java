package _15_HashTable;// 해시 충돌 해결 - 개방 주소법 (이중 해싱)

public class _03_DoubleHashing extends MyHashTable {
    int c;

    _03_DoubleHashing(int length) {
        super(length);
        this.c = this.getHashC(length);
    }

    @Override
    public void setValue(int key, int value) {
        int idx = this.getHash(key);

        if (this.elementCount == this.table.length) {
            System.out.println("Hash table is full!");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = value;
        } else {
            int newIdx = idx;
            int cnt = 1;
            while(true) {
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = value;
        }
        this.elementCount++;
    }

    // 충돌 후 탐사 이동 간격(얼만큼 이동할지)를 구하는 해시함수
    public int getHash2(int key) {

        int hash = 1 + key % this.c;
        return hash;
    }

    // c는 hashTable의 길이보다 조금 작은 소수
    public int getHashC(int length) {
        int c = 0;
        if (length <= 2) {
            return length;
        }
        for (int i = length - 1; i > 2; i--) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                c = i;
                break;
            }
        }
        return c;
    }
}


class DoubleHashingMain {
    public static void main(String[] args) {
        _03_DoubleHashing ht = new _03_DoubleHashing(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();

        ht.setValue(1, 100);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();
    }
}

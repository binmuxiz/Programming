import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MySet {

    // ArrayList
    ArrayList<Integer> list;

    // 생성자1
    MySet() {
        this.list = new ArrayList<>();
    }

    // 생성자2
    MySet(int[] arr) {
        this.list = new ArrayList<>();

        for (int item : arr) {
            this.list.add(item);
        }
    }

    // 원소 추가 (중복 x)
    public void add(int x) {
        for (int item : this.list) {
            if (item == x) {
                return;
            }
        }
        this.list.add(x);
    }

    // 교집합 - 새 교집합 인스턴스 반환
    public MySet retainAll(MySet b) {
        MySet mySet = new MySet();

        for (int itemA : this.list) {
            for (int itemB : b.list) {
                if (itemA == itemB) {
                    mySet.add(itemA);
                    break;
                }
            }
        }
        return mySet;
    }

    // 합집합
    public MySet addAll(MySet b) {
        MySet mySet = new MySet();

        for (int itemA : this.list) {
            mySet.add(itemA);
        }
        for (int itemB : b.list) {
            mySet.add(itemB);
        }
        return mySet;
    }

    // 차집합
    public MySet removeAll(MySet b) {
        MySet mySet = new MySet();

        for (int itemA : this.list) {
            boolean containFlag = false;

            for (int itemB : b.list) {
                if (itemA == itemB) {
                    containFlag = true;
                    break;
                }
            }
            if (!containFlag)
                mySet.add(itemA);
        }
        return mySet;
    }
}

public class Practice {

    public static void main(String[] args) {

        MySet set1 = new MySet();
        set1.add(1);
        set1.add(1);
        set1.add(1);
        System.out.println("set1 = " + set1.list);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1.list);

        // 2. 집합 연산
        MySet a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        // 교집합
        System.out.println("교집합 : " + a.retainAll(b).list);

        // 합집합
        System.out.println("합집합 : " + a.addAll(b).list);

        // 차집합
        System.out.println("차집합 : " + a.removeAll(b).list);
    }
}

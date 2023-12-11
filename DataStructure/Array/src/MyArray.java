public class MyArray {

    int[] arr;

    // 배열의 초기 사이즈 설정

    public MyArray(int size) {
        this.arr = new int[size];
    }

    // 배열에 데이터 삽입
    public void insertData(int index, int data) {
        if (index < 0 || index >= this.arr.length) {
            System.out.println("Index Error");
            return;
        }

        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }
        this.arr[index] = data;
    }

    // 배열에서 특정 데이터 삭제
    public void removeData(int data) {
        int targetIndex = -1;

        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == data) {
                targetIndex = i;
                break;
            }
        }
        if (targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
            return;
        }
        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length - 1];

        for (int i = 0; i < targetIndex; i++) {
            this.arr[i] = arrDup[i];
        }
        for (int i = targetIndex; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i + 1];
        }
    }
}

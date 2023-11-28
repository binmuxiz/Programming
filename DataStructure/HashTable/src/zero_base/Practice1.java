package zero_base;// 해시 테이블을 이용한 수 찾기
// 주어진 첫 번째 배열을 이용하여 해시 테이블을 초기화 한 뒤
// 두 번째 배열이 주어졌을 떄 해당 배열 내 데이터가 해시 테이블에 있는지 확인하는 코드를 작성하시오.

import java.util.Hashtable;

// 입출력 예시
// 배열 1: 1,3,5,7,9
// 배열 2: 1,2,3,4,5
// 출력 : true, false, true, false, true
public class Practice1 {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 2, 3, 4, 5};
        solution(arr1, arr2);
    }

    private static void solution(int[] arr1, int[] arr2) {

        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int item : arr1) {
            ht.put(item, 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (ht.containsKey(arr2[i]))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
    }
}

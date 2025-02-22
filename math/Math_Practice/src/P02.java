import java.util.Arrays;

public class P02 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 1}))); // output : [3,1,2]
        System.out.println(Arrays.toString(solution(new int[]{1, 9, 4, 7, 6}))); // [1,9,4,6,7]
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 2, 3}))); // [1,1,2,3]
        System.out.println(Arrays.toString(solution(new int[]{5, 7, 3, 4, 5}))); // [5,5,3,4,7]
        System.out.println(Arrays.toString(solution(new int[]{5, 7, 3, 6, 6}))); // [5,6,3,7,6]
        System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 1})));
    }

    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2)
            return arr;

        int idx = -1;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i-1]) {
                idx = i - 1;
                break;
            }
        }

        if (idx == -1) { // 감소하지 않는 수열인 경우 바로 종료
            return arr;
        }

        // a 이후의 숫자들 중 가장 큰 숫자를 찾아 swap (가장 큰 숫자가 중복되는 경우 idx가 작은(좌측의) 숫자와 swap)
//        int bIdx = aIdx + 1;
//        int b = arr[bIdx];
//        for (int i = bIdx + 1; i < arr.length; i++) {
//            if (b < arr[i]) {
//                bIdx = i;
//                b = arr[i];
//            }
//        }


        /*
        가장 큰 숫자를 찾을 필요 없음. a 이후의 숫자들은 이미 감소하지 않는 수열이란게 보장된 상태이므로 중복된 숫자가 나오는 경우만 체크하면 됨.
         */
        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[i] != arr[i - 1]) { // swap
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        return arr;
    }
}

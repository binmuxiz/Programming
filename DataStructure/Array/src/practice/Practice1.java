package practice;

public class Practice1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double evenAverage = 0;
        double oddAverage = 0;
        int evenCnt = 0;
        int oddCnt = 0;

        // 짝수 데이터 평균
        // 홀수 데이터 평균
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCnt++;
                evenAverage += arr[i];
            } else {
                oddCnt++;
                oddAverage += arr[i];
            }
        }
        if (evenCnt != 0) {
            evenAverage /= evenCnt;
            System.out.println(evenAverage);
        }
        if (oddCnt != 0) {
            oddAverage /= oddCnt;
            System.out.println(oddAverage);
        }

    }
}

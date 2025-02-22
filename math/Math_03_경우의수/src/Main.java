import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
// 1. 합의 법칙

// 두 개의 주사위를 던졌을 때 합이 3의 배수 또는 4의 배수일 경우의 수
        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

        int nA = 0;
        int nB = 0;
        int nAandB = 0;

// 기본 풀이
        for (int item1 : dice1) {
            for (int item2 : dice2) {
                int sum = item1 + item2;

                if (sum % 3 == 0) {
                    nA++;
                } else if (sum % 4 == 0) {
                    nB++;
                } else if (sum % 12 == 0) {
                    nAandB++;
                }
            }
        }
        System.out.println("경우의 수 = " + (nA + nB - nAandB));

// HashSet 이용

        HashSet<ArrayList> allCase = new HashSet<>(); // 케이스도 모두 저장

        for (int itemA : dice1) {
            for (int itemB : dice2) {
                int sum = itemA + itemB;

                if (sum % 3 == 0 || sum % 4 == 0) {
                    ArrayList<Object> list = new ArrayList<>(Arrays.asList(itemA, itemB));
                    allCase.add(list);
                }
            }
        }
        System.out.println("경우의 수 : " + allCase.size());
        System.out.println("allCase : " + allCase);

// 2. 곱의 법칙

// 두 개의 주사위 a, b를 던졌을 때 a는 3의 배수, b는 4의 배수인 경우의 수
        nA = 0;
        nB = 0;

// 기본 풀이
        for (int itemA : dice1) {
            if (itemA % 3 == 0) {
                nA++;
            }
        }
        for (int itemB : dice2) {
            if (itemB % 4 == 0) {
                nB++;
            }
        }
        System.out.println("경우의 수 : " + (nA * nB));

// HashSet 사용

        HashSet<ArrayList> allCase2 = new HashSet<>();
        for (int itemA : dice1) {
            if (itemA % 3 == 0) {
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(itemA));
                allCase2.add(list);
            }
        }
        for (int itemB : dice2) {
            if (itemB % 4 == 0) {
                for (ArrayList list : allCase2) {
                    list.add(itemB);
                }
            }
        }
        System.out.println("경우의 수 : " + allCase.size());
        System.out.println("allCase2 : " + allCase2);
    }
}

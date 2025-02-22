// 파스칼의 삼각형
// 입력 : 행의 수
// 출력 : 파스칼의 삼각형

import java.util.ArrayList;
import java.util.Arrays;

public class P01 {

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }

    private static ArrayList<ArrayList<Integer>> solution(int rowCnt) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> rowList;

        for (int i = 0; i < rowCnt; i++) {
            rowList = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    rowList.add(1);
                } else {
                    int x = result.get(i - 1).get(j - 1);
                    int y = result.get(i - 1).get(j);
                    rowList.add(x + y);
                }
            }
            result.add(rowList);
        }
        return result;
    }
}


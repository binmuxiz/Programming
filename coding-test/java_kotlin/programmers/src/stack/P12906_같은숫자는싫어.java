package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P12906_같은숫자는싫어 {

    public static void main(String[] args) {
        P12906_같은숫자는싫어 p = new P12906_같은숫자는싫어();
        p.solution2(new int[]{1, 1, 3, 3, 0, 1, 1});
    }

    public int[] solution(int []arr) {
        int[] temp = new int[arr.length];
        int topVal = -1;
        int top = -1;

        for (int item : arr) {
            if (topVal != item) {
                temp[++top] = item;
                topVal = item;
            }
        }
        int[] answer = new int[top + 1];
        for (int i = 0; i < top + 1; i++) {
            answer[i] = temp[i];
        }

        return answer;
    }

    public int[] solution2(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            if (list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

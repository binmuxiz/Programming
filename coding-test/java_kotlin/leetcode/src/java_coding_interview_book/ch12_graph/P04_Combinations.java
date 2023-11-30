package java_coding_interview_book.ch12_graph;

import java.util.ArrayList;
import java.util.List;

// [1,n]까지의 정수에서 k개를 선택하여 만들 수 있는 모든 조합을 리턴하라.
public class P04_Combinations {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        P04_Combinations p = new P04_Combinations();
        System.out.println(p.combine(n, k));

    }

    private List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> elements, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(elements));
            return;
        }

        for (int i = start; i <= n; i++) {
            elements.add(i);
            dfs(result, elements, n, k - 1, i + 1);
//            elements.remove(i); // 이건 remove(int index) 임.. -> IndexOutOfBoundsException 발생함
            elements.remove(elements.size() - 1);

        }
    }
}

package java_coding_interview_book.ch12_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 서로 다른 정수를 입력받아 가능한 모든 순열을 리턴하라
public class P03_Permutations {

    public static void main(String[] args) {
        P03_Permutations p = new P03_Permutations();
        System.out.println(p.permute(new int[]{1, 2, 3}));

    }

    private List<List<Integer>> permute(int[] nums) {
        List<Integer> elements = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), elements);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> prev, List<Integer> elements) {
        if (elements.isEmpty()) {
            result.add(new ArrayList<>(prev));
            return;
        }

        for (Integer item : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(item); // 이건 remove(Object o)

            prev.add(item);
            dfs(result, prev, nextElements);
            prev.remove(item);


        }
    }
}

package java_coding_interview_book.ch12_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P05_Combination_Sum {
    public static void main(String[] args) {
        P05_Combination_Sum p = new P05_Combination_Sum();
        System.out.println(p.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayDeque<>(), target, candidates, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result,  Deque<Integer> path, int target, int[] candidates, int idx) {
        // 목표값에 도달하여 결과를 추가하고 리턴
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (target - candidates[i] < 0) continue;
            path.add(candidates[i]);
            dfs(result, path, target - candidates[i], candidates, i);
            path.removeLast();
        }
    }
}

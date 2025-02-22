package _14_Graph;

import java.util.*;

public class DFS_iterative {
    static Map<Integer, List<Integer>> graph;

    public static void main(String[] args) {

        graph = new HashMap<>();

        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6, 7));
        graph.put(6, Arrays.asList());
        graph.put(7, Arrays.asList(3));

        System.out.println(iterativeDFS(1));
    }

    private static List<Integer> iterativeDFS(int v) {
        // 결과 노드를 저장할 리스트 선언
        List<Integer> discovered = new ArrayList<>();
        // 스택은 효율적인 ArrayDeque 자료형 사용
        Deque<Integer> stack = new ArrayDeque<>();
        // 현재 노드를 스택에 삽입
        stack.push(v);
        // stack이 빌 때까지 반복.
        while (!stack.isEmpty()) {
            v = stack.pop();

            if (!discovered.contains(v)) {
                discovered.add(v);

                for (Integer w : graph.get(v)) {
                    stack.push(w);
                }
            }
        }
        return discovered;
    }
}

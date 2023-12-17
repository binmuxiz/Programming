package _14_Graph;

import java.util.*;

public class BFS_iterative {
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

        System.out.println(iterativeBFS(1));
    }

    private static List<Integer> iterativeBFS(int start_v) {
        // 결과 저장할 리스트
        List<Integer> discovered = new ArrayList<>();
        // 그래프 탐색에 사용할 큐
        Queue<Integer> queue = new LinkedList<>();
        // 시작 노드 삽입
        discovered.add(start_v);
        queue.add(start_v);
        // 큐가 모두 비워질 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 추출
            int v = queue.poll();
            // 현재 노드에서 연결된 모든 주변 노드를 큐에 삽입
            for (int w : graph.get(v)) {
                // 이미 방문한 노드가 아니라면 방문 노드에 추가하고 주변 노드를 모두 큐에 삽입
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }
        return discovered;
    }
}

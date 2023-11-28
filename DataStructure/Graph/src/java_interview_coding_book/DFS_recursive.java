package java_interview_coding_book;

import java.util.*;

public class DFS_recursive {
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

        List<Integer> discovered = new ArrayList<>();
        System.out.println(recursiveDFS(1, discovered));

    }

    private static List<Integer> recursiveDFS(int v, List<Integer> discovered) {
        // 현재 노드 저장 (전위 순회 : 루트->왼쪽자식->오른쪽자식)
        discovered.add(v);

        // 현재 노드의 인접 노드를 탐색
        for (Integer w : graph.get(v)) {
            // 아직 처리되지 않은 노드라면 깊이 기반 탐색 진행
            if (!discovered.contains(w)) {
                discovered = recursiveDFS(w, discovered);
            }
        }
        // 모든 깊이를 탐색하면 return
        return discovered;
    }
}

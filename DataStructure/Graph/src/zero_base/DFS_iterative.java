package zero_base;

import java.util.*;

public class DFS_iterative {

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();

        graph.put('A', Arrays.asList('B', 'C', 'D'));
        graph.put('B', Arrays.asList('A', 'E'));
        graph.put('C', Arrays.asList('A', 'F'));
        graph.put('D', Arrays.asList('A', 'E', 'F'));
        graph.put('E', Arrays.asList('B', 'D', 'G'));
        graph.put('F', Arrays.asList('C', 'D', 'G'));
        graph.put('G', Arrays.asList('E', 'F'));

        iterativeDFS(graph, 'A');

    }

    // DFS 반복 구조 구현은 스택!
    private static void iterativeDFS(Map<Character, List<Character>> graph, Character start_v) {
        boolean[] isVisited = new boolean[graph.size()];
        Deque<Character> stack = new ArrayDeque<>();

        stack.push(start_v);
        isVisited[start_v - 'A'] = true;

        while (!stack.isEmpty()) {
            Character v = stack.pop();
            System.out.print(v + " ");

            for (Character w : graph.get(v)) {
                if (isVisited[w - 'A'] == false) {
                    stack.push(w);
                    isVisited[w - 'A'] = true;
                }
            }
        }
    }
}

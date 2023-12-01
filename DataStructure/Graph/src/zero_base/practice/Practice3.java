package zero_base.practice;

// 주어진 그래프를 두 개의 그래프로 분리할 수 있는지 확인하는 프로그램을 작성하세요.
// 분리 조건 : 인접하지 않은 노드끼리 분리

// 모든 노드는 연결되어 있다.

// 압출력 예시
// 입력 그래프 : {{1,3}, {0,2}, {1,3}, {0,2}} -> 0번 노드가 1,3에 연결, 1번 노드가 0,2에 연결, ...
// 출력 : true

// 입력 그래프 : {{1,3}, {0,2}, {0, 1,3}, {0,2}}
// 출력 : false
public class Practice3 {
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        solution1(graph);

        graph = new int[][]{{1, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        solution1(graph);
    }

    private static void solution1(int[][] graph) {
        int[] flags = new int[graph.length];

        if (checkSplit(graph, flags, 1, 0)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean checkSplit(int[][] graph, int[] flags, int flag, int node) {
        if (flags[node] != 0) {
            return flags[node] == flag;
        }

        flags[node] = flag;

        for (int adjNode : graph[node]) {
            if (!checkSplit(graph, flags, -flag, adjNode)) {
                return false;
            }
        }
        return true;
    }
}

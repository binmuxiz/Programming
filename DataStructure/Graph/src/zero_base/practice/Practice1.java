package zero_base.practice;

// CenterNode 찾기
// Undirected Graph에서 CenterNode를 출력하세요.
// CenterNode는 다른 모든 노드와 연결된 노드를 의미

// 제약조건
// 1. 간선의 총 개수는 노드의 개수 - 1
// 2. 모든 노드는 연결되어 있다.

// 입력 그래프 : {{1,2}, {2,3}, {4,2}}
// 출력 : 2

import zero_base.MyGraphMatrix;

// 입력 그래프 : {{1,2}, {5,1}, {1,3}, {1,4}}
// 출력 : 1
public class Practice1 {

    public static void main(String[] args) {
        Practice1 p = new Practice1();
        System.out.println(p.solution1(new int[][]{{1,2}, {2,3}, {4,2}}));
        System.out.println(p.solution1(new int[][]{{1,2}, {5,1}, {1,3}, {1,4}}) );

        System.out.println(p.solution2(new int[][]{{1,2}, {2,3}, {4,2}}));
        System.out.println(p.solution2(new int[][]{{1,2}, {5,1}, {1,3}, {1,4}}) );

    }

    private int solution1(int[][] edges) {
        // 정점의 개수 = 간선의 개수 + 1
        int vertexCnt = edges.length + 1;
        GraphAdjacentMatrix graph = new GraphAdjacentMatrix(vertexCnt);

        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0] - 1, edges[i][1] - 1);
        }

        int[] edgeCounts = new int[vertexCnt];
        for (int i = 0; i < vertexCnt; i++) {
            for (int j = 0; j < vertexCnt; j++) {
                if (graph.matrix[i][j] == 1) {
                    edgeCounts[i]++;
                }
            }
        }
        int idx = 0;
        for (int i = 0; i < vertexCnt; i++) {
            if (edgeCounts[i] == vertexCnt - 1) {
                idx = i;
                break;
            }
        }
        return idx + 1;
    }

    private int solution2(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}

class GraphAdjacentMatrix {
    int[][] matrix;

    public GraphAdjacentMatrix(int size) {
        this.matrix = new int[size][size];
    }

    public void addEdge(int x, int y) {
        this.matrix[x][y] = 1;
        this.matrix[y][x] = 1;
    }
}
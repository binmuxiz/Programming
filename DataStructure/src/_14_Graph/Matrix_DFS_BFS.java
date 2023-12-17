package _14_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 인접 행렬 그래프의 DFS, BFS
class MyGraphMatrix2 extends MyGraphMatrix {
    public MyGraphMatrix2(int size) {
        super(size);
    }


    // 반복구조로 구현한 dfs. Stack 자료구조 사용
    public void dfs(int start_v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[this.elementCnt];

        stack.push(start_v);
        visited[start_v] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.print(this.vertices[v] + " ");

            for (int i = 0; i < this.elementCnt; i++) {
                if (this.adjacentMatrix[v][i] == 1 && visited[i] == false) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    // 반복구조로 구현한 bfs. Queue 사용
    public void bfs(int start_v) {
        boolean[] visited = new boolean[this.elementCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start_v);
        visited[start_v] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(this.vertices[v] + " ");

            for (int i = 0; i < this.elementCnt; i++) {
                if (this.adjacentMatrix[v][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class Matrix_DFS_BFS {

    public static void main(String[] args) {
        MyGraphMatrix2 m = new MyGraphMatrix2(4);
        m.addVertex('A');
        m.addVertex('B');
        m.addVertex('C');
        m.addVertex('D');

        m.addVertex('E');

        m.addEdge(0, 1);
        m.addEdge(0, 2);
        m.addEdge(1, 2);
        m.addEdge(1, 3);
        m.addEdge(2, 3);

        m.printAdjacentMatrix();

        System.out.print("DFS : ");
        m.dfs(0);

        System.out.println();
        System.out.print("BFS : ");
        m.bfs(0);
    }
}

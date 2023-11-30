package zero_base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphList2 extends MyGraphList {

    public MyGraphList2(int size) {
        super(size);
    }

    public void dfs(int start_v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[this.elementCnt];

        stack.push(start_v);
        isVisited[start_v] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.print(this.vertices[v] + " ");

            Node cur = this.adjacentList[v];
            while (cur != null) {
                if (isVisited[cur.id] == false) {
                    stack.push(cur.id);
                    isVisited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
    }

    public void bfs(int start_v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[this.elementCnt];

        queue.add(start_v);
        isVisited[start_v] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(this.vertices[v] + " ");

            Node cur = this.adjacentList[v];
            while (cur != null) {
                if (isVisited[cur.id] == false) {
                    queue.add(cur.id);
                    isVisited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
    }
}

public class List_DFS_BFS {
    public static void main(String[] args) {
        MyGraphList2 m = new MyGraphList2(4);
        m.addVertex('A'); // 0
        m.addVertex('B'); // 1
        m.addVertex('C'); // 2
        m.addVertex('D'); // 3

        m.addVertex('E');

        m.addEdge(0, 1);
        m.addEdge(0, 2);
        m.addEdge(1, 2);
        m.addEdge(1, 3);
        m.addEdge(2, 3);

        m.printAdjacentMatrix();

        m.deleteEdge(1,2);

        m.printAdjacentMatrix();

        System.out.println();
        m.dfs(0);

        System.out.println();
        m.bfs(0);

    }
}

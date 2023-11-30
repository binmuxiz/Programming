package zero_base.practice;

import java.util.Stack;

public class Practice2 {
    public static void main(String[] args) {
        // n은 노드의 개수
        int n = 3;
        int[][] edges = new int[][]{{0,1}, {1,2}, {2,0}};
        int source = 0;
        int dest = 1;
        System.out.println(solution1(n, edges, source, dest));

        n = 6;
        edges = new int[][]{{0, 1}, {0, 2}, {3, 4}, {4, 5}, {3, 5}};
        source = 3;
        dest = 4;
        System.out.println(solution1(n, edges, source, dest));
    }

    // source부터 dfs로 방문한 노드는 visited에 true로 표시해주고, dest가 true라면 길이 있는 것.
    private static void dfs(boolean[] isVisited, int source, GraphAdjacentList graph) {
        Stack<Integer> stack = new Stack<>();

        stack.push(source);
        isVisited[source] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.print(v + " ");

            Node cur = graph.adjacentList[v];
            while (cur != null) {
                if (isVisited[cur.id] == false) {
                    stack.push(cur.id);
                    isVisited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
    }

    private static boolean solution1(int n, int[][] edges, int source, int dest) {
        GraphAdjacentList graph = new GraphAdjacentList(n);

        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }

        boolean[] isVisited = new boolean[n];

        dfs(isVisited, source, graph);

        return isVisited[dest];
    }
}

class GraphAdjacentList {
    Node[] adjacentList;

    public GraphAdjacentList(int size) {
        this.adjacentList = new Node[size];
    }

    public void addEdge(int x, int y) {
        this.adjacentList[x] = new Node(y, this.adjacentList[x]);
        this.adjacentList[y] = new Node(x, this.adjacentList[y]);
    }

    public void printGraph() {
        for (int i = 0; i < this.adjacentList.length; i++) {
            System.out.print(i + " -> ");

            Node cur = this.adjacentList[i];
            while (cur != null) {
                System.out.print(cur.id + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}

class Node {
    int id;
    Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}


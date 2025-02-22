package _14_Graph;


// 인접 리스트을 이용한 그래프 구현
public class MyGraphList {
    char[] vertices;
    Node[] adjacentList;
    int elementCnt;

    public MyGraphList() {}

    public MyGraphList(int size) {
        this.vertices = new char[size];
        this.adjacentList = new Node[size];
        this.elementCnt = elementCnt;
    }

    public boolean isFull() {
        return this.elementCnt == this.vertices.length;
    }

    public void addVertex(char vertex) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }
        vertices[elementCnt++] = vertex;
    }

    public void addEdge(int x, int y) {
        adjacentList[x] = new Node(y, adjacentList[x]);
        adjacentList[y] = new Node(x, adjacentList[y]);
    }

    public void addDirectedEdge(int x, int y) {
        adjacentList[x] = new Node(y, adjacentList[x]);
    }

    public void deleteEdge(int x, int y) {
        Node cur = adjacentList[x];
        Node prev = cur;
        if (cur.id == y) {
            adjacentList[x] = cur.next;
        } else {
            cur = cur.next;

            while (cur != null) {
                if (cur.id == y) {
                    prev.next = cur.next;
                    break;
                }
                cur = cur.next;
            }
        }

        cur = adjacentList[y];
        prev = cur;
        if (cur.id == x) {
            adjacentList[y] = cur.next;
        } else {
            cur = cur.next;

            while (cur != null) {
                if (cur.id == x) {
                    prev.next = cur.next;
                    break;
                }
                cur = cur.next;
            }
        }
    }

    public void printAdjacentMatrix() {
        for (int i = 0; i < elementCnt; i++) {
            System.out.print(vertices[i] + " -> ");

            Node cur = adjacentList[i];
            while (cur != null) {
                System.out.print(vertices[cur.id] + " ");
                cur = cur.next;
            }
            System.out.println();
        }
        System.out.println();
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

class Main2 {
    public static void main(String[] args) {
        MyGraphList m = new MyGraphList(4);
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

    }
}